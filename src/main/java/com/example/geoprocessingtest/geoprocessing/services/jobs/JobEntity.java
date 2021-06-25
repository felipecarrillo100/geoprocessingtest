package com.example.geoprocessingtest.geoprocessing.services.jobs;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table(name = "jobs")
public class JobEntity {

    @Id
    @Size(max = 128)
    @NotNull
    @NotEmpty
    private String jobID;

    @Column
    @Size(max = 64)
    @NotNull
    @NotEmpty
    private String status;

    @Column
    @Size(max = 128)
    @NotNull
    @NotEmpty
    private String processID;

    @Column
    @Size(max = 64)
    private String created;  // "2021-06-09T16:00:00.262Z",

    @Column
    @Size(max = 64)
    private String started;  // "2021-06-09T16:00:06.260Z",

    @Column
    @Size(max = 64)
    private String finished; // "2021-06-09T16:00:22.698Z",

    @Column
    private Long progress;   // 100

    public JobEntity() {
    }

    public JobEntity(String processID) {
        this.processID = processID;
        this.jobID = UUID.randomUUID().toString();
        this.status = "accepted";
        this.setCreated(GetCurrentMoment.nowAsISO());
        this.setStarted(GetCurrentMoment.nowAsISO());
        this.setProgress(0L);
    }

    public String getJobID() {
        return jobID;
    }

    public void setJobID(String jobID) {
        this.jobID = jobID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProcessID() {
        return processID;
    }

    public void setProcessID(String processID) {
        this.processID = processID;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getStarted() {
        return started;
    }

    public void setStarted(String started) {
        this.started = started;
    }

    public String getFinished() {
        return finished;
    }

    public void setFinished(String finished) {
        this.finished = finished;
    }

    public Long getProgress() {
        return progress;
    }

    public void setProgress(Long progress) {
        this.progress = progress;
    }
}
