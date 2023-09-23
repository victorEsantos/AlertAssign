package com.victor.alertassign.job;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Job {
    @Id
    private UUID id;

    private String cron;

}
