package com.wunian.weather.controller;

import com.wunian.weather.service.CityDataService;
import com.wunian.weather.service.WeatherDataService;
import com.wunian.weather.service.WeatherReportService;
import com.wunian.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author wunian
 * @desc 天气预报controller
 * @date 2019/7/24 0024
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController{


        @Autowired
        CityDataService cityDataService;

        @Autowired
        WeatherReportService weatherReportService;

        @GetMapping("/cityId/{cityId}")
        public ModelAndView getReportbyCityId(@PathVariable("cityId")String cityId,Model model) throws Exception {
            model.addAttribute("title","勿念的天气预报");
            model.addAttribute("cityId",cityId);
            model.addAttribute("cityList",cityDataService.listCity());
            model.addAttribute("report",weatherReportService.getDataByCityId(cityId));

            return new ModelAndView("weather/report","reportModel",model);
        }


}
