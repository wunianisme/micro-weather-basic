package com.wunian.weather.service;

import com.wunian.weather.vo.WeatherResponse;

/**
 * @author wunian
 * @desc 天气数据服务接口
 * @date 2019/7/24 0024
 */
public interface WeatherDataService {

    /**
     * 根据城市ID查询天气数据
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市名称查询天气数据
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);

    /**
     * 根据城市ID来同步天气
     * @param cityId
     */
    void syncDataByCityId(String cityId);
}
