package com.wunian.weather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wunian.weather.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author wunian
 * @desc
 * @date 2019/7/24 0024
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private Logger logger=LoggerFactory.getLogger(WeatherDataServiceImpl.class);//日志操作对象slf4j

    //访问天气接口的uri
    private static final String WEATHER_URI="http://wthrcdn.etouch.cn/weather_mini?";

    public static final  long TIME_OUT=1800L;//缓存超时时间，实际一般设置为三十分钟，即1800

    @Autowired
    private RestTemplate restTemplate;//http访问对象

    @Autowired
    private StringRedisTemplate stringRedisTemplate;//redis字符串访问对象

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri=WEATHER_URI+"citykey="+cityId;
        return  doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {

        String uri=WEATHER_URI+"city="+cityName;

        return doGetWeather(uri);
    }



    /**
     * 获取天气数据(先查redis再访问天气服务接口)
     * @param uri
     * @return
     */
    private WeatherResponse doGetWeather(String uri){
        String strBody=null;
        WeatherResponse resp=null;
        String key=uri;
        ValueOperations<String,String> ops=stringRedisTemplate.opsForValue();
        //先查缓存，缓存有的取缓存中的数据
        if(stringRedisTemplate.hasKey(uri)){
            logger.info("Redis has data");
            strBody=ops.get(key);
        }else{

            logger.info("Redis don't has data");
            //缓存没有，再调用服务接口来获取

            //访问天气接口，获得数据
            ResponseEntity<String> respString=restTemplate.getForEntity(uri,String.class);

            //解析JSON字符串数据
            if(respString.getStatusCodeValue()==200) {//判断响应对象的状态码，200表示成功
                strBody=respString.getBody();
            }
            //数据写入缓存
            ops.set(key,strBody,TIME_OUT,TimeUnit.SECONDS);
        }

        ObjectMapper mapper=new ObjectMapper();
        try {
            resp=mapper.readValue(strBody,WeatherResponse.class);
        }catch(IOException e){
            //e.printStackTrace();
            logger.error("errorInfo{}",e.getMessage());
        }

        return resp;
    }

    @Override
    public void syncDataByCityId(String cityId) {
        String uri=WEATHER_URI+"citykey="+cityId;
        saveWeatherData(uri);
    }

    /**
     * 把天气数据放在缓存中
     * @param uri
     */
    private void saveWeatherData(String uri){
        String strBody=null;
        String key=uri;
        ValueOperations<String,String> ops=stringRedisTemplate.opsForValue();

        //访问天气接口，获得数据
        ResponseEntity<String> respString=restTemplate.getForEntity(uri,String.class);

        //解析JSON字符串数据
        if(respString.getStatusCodeValue()==200) {//判断响应对象的状态码，200表示成功
            strBody=respString.getBody();
        }
        //数据写入缓存
        ops.set(key,strBody,TIME_OUT,TimeUnit.SECONDS);
    }
}
