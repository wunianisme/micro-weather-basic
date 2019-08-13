package com.wunian.weather.service;

import com.wunian.weather.util.XmlBuilder;
import com.wunian.weather.vo.City;
import com.wunian.weather.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author wunian
 * @desc
 * @date 2019/7/24 0024
 */
@Service
public class CityDataServiceImpl implements CityDataService {


    @Override
    public List<City> listCity() throws Exception {
        //读取xml文件
        Resource resource=new ClassPathResource("citylist.xml");
        BufferedReader reader=new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));
        StringBuffer buffer=new StringBuffer();
        String line="";
        while((line=reader.readLine())!=null){
            buffer.append(line);
        }
        reader.close();
        //xml转为java对象
        CityList cityList= (CityList) XmlBuilder.xmlStrToObject(CityList.class,buffer.toString());


        return cityList.getCityList();
    }
}
