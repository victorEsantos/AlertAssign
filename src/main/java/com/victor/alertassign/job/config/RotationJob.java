package com.victor.alertassign.job.config;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class RotationJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // Lógica específica para jobs de tipo "Rotação"
        System.out.println("Executando job de tipo Rotação");
    }
}
