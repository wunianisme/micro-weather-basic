package com.wunian.weather.vo;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author wunian
 * @desc 城市列表
 * @date 2019/7/24 0024
 */
@XmlRootElement(name="c")  //声明为xml的根元素c
@XmlAccessorType(XmlAccessType.FIELD)  //通过字段来访问
public class CityList implements Serializable {

    @XmlElement(name="d") //映射的xml元素
    private List<City> cityList;

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
