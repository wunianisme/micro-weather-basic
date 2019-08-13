package com.wunian.weather.vo;

import java.io.Serializable;

/**
 * @author wunian
 * @desc 未来天气
 * @date 2019/7/24 0024
 */
public class Forecast implements Serializable {

    private String date;

    private String high;

    private String fengli;

    private String low;

    private String fengxiang;

    private String type;


    public Forecast(){}

    public Forecast(String date, String high, String fengli, String low, String fengxiang, String type) {
        this.date = date;
        this.high = high;
        this.fengli = fengli;
        this.low = low;
        this.fengxiang = fengxiang;
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getFengli() {
        return fengli;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getFengxiang() {
        return fengxiang;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
