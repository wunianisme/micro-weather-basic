package com.wunian.weather.service;

import com.wunian.weather.vo.Weather;
import com.wunian.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wunian
 * @desc
 * @date 2019/7/24 0024
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse resp=weatherDataService.getDataByCityId(cityId);

        return resp.getData();
    }
}
