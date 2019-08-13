package com.wunian.weather.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author wunian
 * @desc  城市信息 解析citylist.xml获取
 * @date 2019/7/24 0024
 */
@XmlRootElement(name="d")  //声明为xml的根元素d
@XmlAccessorType(XmlAccessType.FIELD)  //通过字段来访问
public class City implements Serializable {

    @XmlAttribute(name="d1") //映射的xml属性
    private String cityId;
    @XmlAttribute(name="d2")
    private String cityName;
    @XmlAttribute(name="d3")
    private String cityCode;
    @XmlAttribute(name="d4")
    private String province;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
