package com.example.geoprocessingtest.geoprocessing.process;

import java.util.ArrayList;
import java.util.List;

public class GeoProcessingProcessSimplified {
    private String title;
    private String description;

    private AdditionalParameters additionalParameters;
    private String id;
    private String version;
    private List<String> jobControlOptions;
    private List<GeoProcessingProcessLinks> links;
    private Boolean isStatic;

    public GeoProcessingProcessSimplified(String title, String description, AdditionalParameters additionalParameters, String id, String version, Boolean isStatic) {
        this.title = title;
        this.description = description;
        this.additionalParameters = additionalParameters;
        this.id = id;
        this.version = version;
        this.jobControlOptions = new ArrayList<String>();
        this.links = new ArrayList<GeoProcessingProcessLinks>();
        this.isStatic = isStatic;
    }

    public GeoProcessingProcessSimplified(String title, String description, AdditionalParameters additionalParameters, String id, String version, List<String> jobControlOptions, List<GeoProcessingProcessLinks> links, Boolean isStatic) {
        this.title = title;
        this.description = description;
        this.additionalParameters = additionalParameters;
        this.id = id;
        this.version = version;
        this.jobControlOptions = jobControlOptions;
        this.links = links;
        this.isStatic = isStatic;
    }

    public GeoProcessingProcessSimplified(GeoProcessingProcess p) {
        this.title = p.getTitle();
        this.description = p.getDescription();
        this.additionalParameters = p.getAdditionalParameters();
        this.id = p.getId();
        this.version = p.getVersion();
        this.jobControlOptions = p.getJobControlOptions();
        this.links = cloneListLinks(p.getLinks());
        this.isStatic = p.getStatic();
    }

    public static List<GeoProcessingProcessLinks> cloneListLinks(List<GeoProcessingProcessLinks> list) {
        List<GeoProcessingProcessLinks> clone = new ArrayList<GeoProcessingProcessLinks>();
        for (GeoProcessingProcessLinks item : list) clone.add(item.clone());
        return clone;
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

}
