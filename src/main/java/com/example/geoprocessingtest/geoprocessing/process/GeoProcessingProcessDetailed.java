package com.example.geoprocessingtest.geoprocessing.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GeoProcessingProcessDetailed {
    ResourceLoader resourceLoader;

    private String title;
    private String description;

    private String  id;
    private List<String> jobControlOptions;

    private List<String> keywords;
    private GenericJSON inputs;

    public String loadInputs(ResourceLoader resourceLoader, String filename) {
        String prefix = "inputs/";
        String sufix = ".json";
        String resource = prefix + filename + sufix;
        InputStream in = getInputStreamFromResources(resourceLoader, resource);
        if (in != null) {
            String jsonInput = loadFileContent(in);
            return jsonInput;
        }
        return "{}";
    }

    private static String loadFileContent(InputStream in) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            String jsonString = "";
            while ((line = br.readLine()) != null) {
                jsonString += line;
            }
            return jsonString;
        } catch (IOException e) {
            return "";
        }
    }

    private InputStream getInputStreamFromResources(ResourceLoader resourceLoader, String fileName) {
        Resource resource = resourceLoader.getResource("classpath:" + fileName);
        try {
            return resource.getInputStream();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }


    public GeoProcessingProcessDetailed(String title, String description, String id) {
        this.title = title;
        this.description = description;
        this.id = id;
        this.jobControlOptions = new ArrayList<String>();

        keywords = new ArrayList<String>();
        inputs = new GenericJSON();
    }

    public GeoProcessingProcessDetailed(GeoProcessingProcess p) {
        this.title = p.getTitle();
        this.description = p.getDescription();
        this.id = p.getId();
        this.jobControlOptions = p.getJobControlOptions();

        keywords = p.getKeywords();
        inputs = p.getInputs();
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getJobControlOptions() {
        return jobControlOptions;
    }

    public void setJobControlOptions(List<String> jobControlOptions) {
        this.jobControlOptions = jobControlOptions;
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
}
