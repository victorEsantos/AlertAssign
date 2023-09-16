package com.victor.alertassign.job;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.UUID;

@Entity
public class Job {
    @Id
    private UUID id;

    private String cron;

    @OneToMany(mappedBy = "jobId")
    private List<JobExecs> execs;
}
