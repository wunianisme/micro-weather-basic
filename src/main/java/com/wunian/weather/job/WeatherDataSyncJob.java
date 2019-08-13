package com.wunian.weather.job;

import com.wunian.weather.service.CityDataService;
import com.wunian.weather.service.WeatherDataService;
import com.wunian.weather.vo.City;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * @author wunian
 * @desc  一个具体的JOb,在QuartzConfiguration中调用此Job(quartz的使用)
 * @date 2019/7/24 0024
 */
public class WeatherDataSyncJob extends QuartzJobBean {

    private final static Logger logger=LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherDataService weatherDataService;


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {//执行的动作
        logger.info("Weather data Sync Job start");
        //获取城市ID列表
        List<City> cityList=null;
        try {
            cityList=cityDataService.listCity();
        } catch (Exception e) {
            logger.error("Exception", e);
        }

        //遍历城市ID获取天气
        for(City city:cityList){
            String cityId=city.getCityId();
            logger.info("Weather Data sync job ,cityId:{}",cityId);
            weatherDataService.syncDataByCityId(cityId);
        }
        logger.info("Weather data Sync Job end");
    }
}
