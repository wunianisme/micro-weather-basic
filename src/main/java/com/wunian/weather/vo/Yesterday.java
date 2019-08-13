package com.wunian.weather.vo;

import java.io.Serializable;

/**
 * @author wunian
 * @desc 昨日天气
 * @date 2019/7/24 0024
 */
public class Yesterday implements Serializable {

    private String date;

    private String high;

    private String fx;

    private String low;

    private String fl;

    private String type;

    public Yesterday(){}

    public Yesterday(String date, String high, String fx, String low, String fl, String type) {
        this.date = date;
        this.high = high;
        this.fx = fx;
        this.low = low;
        this.fl = fl;
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

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
