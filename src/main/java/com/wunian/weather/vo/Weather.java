package com.wunian.weather.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author wunian
 * @desc 天气信息
 * @date 2019/7/24 0024
 */
public class Weather implements Serializable {

    private String city;//城市

    private String aqi;//空气指标

    private String ganmao;//提示信息

    private String Wendu;//温度

    private Yesterday yesterday;//昨天天气

    private List<Forecast> forecast;//未来天气列表

    public Weather(){}

    public Weather(String city, String aqi, String ganmao, String wendu, Yesterday yesterday, List<Forecast> forecast) {
        this.city = city;
        this.aqi = aqi;
        this.ganmao = ganmao;
        Wendu = wendu;
        this.yesterday = yesterday;
        this.forecast = forecast;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public String getWendu() {
        return Wendu;
    }

    public void setWendu(String wendu) {
        Wendu = wendu;
    }

    public Yesterday getYesterday() {
        return yesterday;
    }

    public void setYesterday(Yesterday yesterday) {
        this.yesterday = yesterday;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }
}
