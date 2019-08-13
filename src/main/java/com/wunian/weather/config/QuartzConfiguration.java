package com.wunian.weather.config;

import com.wunian.weather.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wunian
 * @desc Quartz的配置类
 * @date 2019/7/24 0024
 */
@Configuration
public class QuartzConfiguration {

    private static final int TIME=1800;//更新频率

    //创建JobDetail
    @Bean
    public JobDetail weatherDataSyncJobDetail(){
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJob")
                .storeDurably().build();
    }
    //创建trigger，执行JobDetail
   /* @Bean
    public Trigger weatherDataSyncTrigger(){
        //每隔1800秒重复执行
        SimpleScheduleBuilder schedBuilder=SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(TIME).repeatForever();

        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail())
                .withIdentity("weatherDataSyncTrigger")//定义trigger的名称
                .withSchedule(schedBuilder).build();
    }*/


}
