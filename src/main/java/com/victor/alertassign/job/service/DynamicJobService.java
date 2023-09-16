package com.victor.alertassign.job.service;

import com.victor.alertassign.job.config.AlertAssignJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

@Service
public class DynamicJobService {

    private final Scheduler scheduler;

    @Autowired
    public DynamicJobService(SchedulerFactoryBean schedulerFactoryBean) {
        this.scheduler = schedulerFactoryBean.getScheduler();
    }

    public void registerDynamicJob(String jobName, String cronExpression) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(AlertAssignJob.class)
                .withIdentity(jobName)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(jobName + "Trigger")
                .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
    }

    public void cancelJob(String jobName) throws SchedulerException {
        scheduler.deleteJob(new JobKey(jobName));
    }
}
