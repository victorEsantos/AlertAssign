package com.victor.alertassign.job.service;

import com.victor.alertassign.job.config.AlertJob;
import com.victor.alertassign.job.config.RotationJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
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
@Slf4j
public class DynamicJobService {

    private final Scheduler scheduler;

    @Autowired
    public DynamicJobService(SchedulerFactoryBean schedulerFactoryBean) {
        this.scheduler = schedulerFactoryBean.getScheduler();
    }

    public void registerAlertJob(String jobName, String cronExpression, String taskId) throws SchedulerException {
        log.info("Registering job {} with cron {}", jobName, cronExpression);
        registerDynamicJob(jobName, cronExpression, AlertJob.class, taskId);
    }

    public void registerRotationJob(String jobName, String cronExpression, String taskId) throws SchedulerException {
        log.info("Registering job {} with cron {}", jobName, cronExpression);
        registerDynamicJob(jobName, cronExpression, RotationJob.class, taskId);
    }

    private void registerDynamicJob(String jobName, String cronExpression, Class <? extends Job> clazz, String taskId) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(clazz)
                .withIdentity(jobName)
                .usingJobData("taskId", taskId)
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
