package com.example.geoprocessingtest.geoprocessing.process;

import com.example.geoprocessingtest.geoprocessing.services.jobs.JobEntity;

import java.util.List;

public class Jobs {
    private List<JobEntity> jobs;
    private List<JobLinks> links;

    public List<JobEntity> getJobs() {
        return jobs;
    }

    public void setJobs(List<JobEntity> jobs) {
        this.jobs = jobs;
    }

    public List<JobLinks> getLinks() {
        return links;
    }

    public void setLinks(List<JobLinks> links) {
        this.links = links;
    }
}
