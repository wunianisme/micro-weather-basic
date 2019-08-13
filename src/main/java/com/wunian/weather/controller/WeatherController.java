package com.wunian.weather.controller;

import com.wunian.weather.service.WeatherDataService;
import com.wunian.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wunian
 * @desc 天气Controller
 * @date 2019/7/24 0024
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    WeatherDataService weatherDataService;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherbyCityId(@PathVariable("cityId")String cityId){

        return weatherDataService.getDataByCityId(cityId);
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable("cityName")String cityName){

        return weatherDataService.getDataByCityName(cityName);
    }
}
