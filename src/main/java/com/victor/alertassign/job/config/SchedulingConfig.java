package com.victor.alertassign.job.config;

import org.quartz.JobExecutionException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulingConfig {
    @Bean
    public AlertJob myScheduledJob() {
//        return new AlertJob();
        return null;
    }

//    @Scheduled(cron = "0 0 7 ? * MON")
//    @Scheduled(cron = "* * * * * ?")
    @Scheduled(cron = "0 * * ? * *")
    public void runMyJob() throws JobExecutionException {
        myScheduledJob().execute(null);
    }
}
