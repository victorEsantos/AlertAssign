package com.victor.alertassign.job.api;

import com.victor.alertassign.job.service.DynamicJobService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class DynamicJobController {

    private final DynamicJobService jobService;

    @Autowired
    public DynamicJobController(DynamicJobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/register")
    public void registerJob(@RequestParam String jobName, @RequestParam String cronExpression) throws SchedulerException {
        jobService.registerDynamicJob(jobName, cronExpression);
    }

    @PostMapping("/cancel")
    public void cancelJob(@RequestParam String jobName) throws SchedulerException {
        jobService.cancelJob(jobName);
    }
}
