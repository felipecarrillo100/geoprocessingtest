package com.example.geoprocessingtest.geoprocessing.process;

import java.util.UUID;

public class JobStartSimplified {
    private String status; // "successful",
    private String jobID;

    public JobStartSimplified() {
        this.jobID = UUID.randomUUID().toString();
        this.status = "accepted";
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

}
