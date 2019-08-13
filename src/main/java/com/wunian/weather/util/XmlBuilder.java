package com.wunian.weather.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * @author wunian
 * @desc Xml解析的工具类
 * @date 2019/7/24 0024
 */
public class XmlBuilder {

    /**
     * 将XML转为指定的POJO对象
     * @param clazz
     * @param xmlStr
     * @return
     */
    public static Object xmlStrToObject(Class<?> clazz,String xmlStr) throws Exception {
        Object xmlObject=null;
        Reader reader=null;
        JAXBContext context=JAXBContext.newInstance(clazz);
        //xml转为对象的接口
        Unmarshaller unmarshaller=context.createUnmarshaller();
        reader=new StringReader(xmlStr);
        xmlObject=unmarshaller.unmarshal(reader);
        if(null!=reader){
            reader.close();
        }
        return xmlObject;
    }
}
