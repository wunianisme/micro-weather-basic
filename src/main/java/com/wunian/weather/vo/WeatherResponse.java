package com.wunian.weather.vo;

import java.io.Serializable;

/**
 * @author wunian
 * @desc 天气接口返回的数据对象
 * @date 2019/7/24 0024
 */
public class WeatherResponse implements Serializable {

    private Weather data; //天气数据

    private Integer status;//状态

    private String desc;//描述

    public WeatherResponse(){}

    public WeatherResponse(Weather data, Integer status, String desc) {
        this.data = data;
        this.status = status;
        this.desc = desc;
    }

    public Weather getData() {
        return data;
    }

    public void setData(Weather data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
