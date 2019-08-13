package com.wunian.weather.service;

import com.wunian.weather.vo.City;

import java.util.List;

/**
 * @author wunian
 * @desc 城市数据服务
 * @date 2019/7/24 0024
 */
public interface CityDataService {

    /**
     * 获取city列表
     * @return
     * @throws Exception
     */
    List<City> listCity() throws Exception;
}
