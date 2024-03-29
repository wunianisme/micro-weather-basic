package com.wunian.weather.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author wunian
 * @desc RestTemplate配置类
 * @date 2019/7/24 0024
 */
@Configuration
public class RestConfiguration {

    @Autowired
    private RestTemplateBuilder builder;


    @Bean
    public RestTemplate restTemplate(){
        return builder.build();
    }
}