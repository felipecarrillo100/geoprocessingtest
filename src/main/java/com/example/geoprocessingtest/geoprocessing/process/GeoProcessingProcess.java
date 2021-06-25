package com.example.geoprocessingtest.geoprocessing.process;

import com.example.geoprocessingtest.geoprocessing.services.jobs.GetCurrentMoment;
import com.example.geoprocessingtest.geoprocessing.services.jobs.JobEntity;
import com.example.geoprocessingtest.geoprocessing.services.jobs.JobRepository;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GeoProcessingProcess {

    private String title;
    private String description;

    private AdditionalParameters additionalParameters;
    private String  id;
    private String  version;
    private List<String> jobControlOptions;
    private List<GeoProcessingProcessLinks> links;
    private Boolean isStatic;

    private List<String> keywords;
    private GenericJSON inputs;


    public GeoProcessingProcess(String title, String description, AdditionalParameters additionalParameters, String id, String version, Boolean isStatic) {
        this.title = title;
        this.description = description;
        this.additionalParameters = additionalParameters;
        this.id = id;
        this.version = version;
        this.jobControlOptions = new ArrayList<String>();
        this.links = new ArrayList<GeoProcessingProcessLinks>();
        this.isStatic = isStatic;

        keywords = new ArrayList<String>();
        inputs = new GenericJSON();
    }

    public GeoProcessingProcess(String title, String description, String id, String version, Boolean isStatic) {
        this.title = title;
        this.description = description;
        this.additionalParameters = new AdditionalParameters();
        this.id = id;
        this.version = version;
        this.jobControlOptions = new ArrayList<String>();
        this.links = new ArrayList<GeoProcessingProcessLinks>();
        this.isStatic = isStatic;

        keywords = new ArrayList<String>();
        inputs = new GenericJSON();
    }

    public GeoProcessingProcess(String title, String description, AdditionalParameters additionalParameters, String id, String version, List<String> jobControlOptions, List<GeoProcessingProcessLinks> links, Boolean isStatic) {
        this.title = title;
        this.description = description;
        this.additionalParameters = additionalParameters;
        this.id = id;
        this.version = version;
        this.jobControlOptions = jobControlOptions;
        this.links = links;
        this.isStatic = isStatic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AdditionalParameters getAdditionalParameters() {
        return additionalParameters;
    }

    public void setAdditionalParameters(AdditionalParameters additionalParameters) {
        this.additionalParameters = additionalParameters;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<String> getJobControlOptions() {
        return jobControlOptions;
    }

    public void setJobControlOptions(List<String> jobControlOptions) {
        this.jobControlOptions = jobControlOptions;
    }

    public List<GeoProcessingProcessLinks> getLinks() {
        return links;
    }

    public void setLinks(List<GeoProcessingProcessLinks> links) {
        this.links = links;
    }

    public Boolean getStatic() {
        return isStatic;
    }

    public void setStatic(Boolean aStatic) {
        isStatic = aStatic;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public GenericJSON getInputs() {
        return inputs;
    }

    public void setInputs(GenericJSON inputs) {
        this.inputs = inputs;
    }

    public void execute(HttpServletRequest request, ResourceLoader resourceLoader, JobRepository jobRepository, JobEntity job, GenericJSON body) {
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        JobEntity jobEntity = jobRepository.findJobEntityByJobID(job.getJobID());
                        if (jobEntity != null) {
                            jobEntity.setProgress(100L);
                            jobEntity.setFinished(GetCurrentMoment.nowAsISO());
                            jobEntity.setStatus("successful");
                            jobRepository.save(jobEntity);
                        }
                    }
                },
                10000
        );
    }
}
