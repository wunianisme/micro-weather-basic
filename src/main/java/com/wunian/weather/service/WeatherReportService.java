package com.wunian.weather.service;

import com.wunian.weather.vo.Weather;

/**
 * @author wunian
 * @desc 天气预报服务
 * @date 2019/7/24 0024
 */
public interface WeatherReportService {

    /**
     * 根据cityID查询天气信息
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);
}
