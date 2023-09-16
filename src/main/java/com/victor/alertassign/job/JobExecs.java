package com.victor.alertassign.job;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
public class JobExecs {

    @Id
    private UUID id;

    private UUID jobId;
    private ZonedDateTime execDateTime;

    @ManyToOne
    private Job job;
}
