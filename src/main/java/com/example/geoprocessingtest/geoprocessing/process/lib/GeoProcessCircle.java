package com.example.geoprocessingtest.geoprocessing.process.lib;

import com.example.geoprocessingtest.geoprocessing.process.*;
import com.example.geoprocessingtest.geoprocessing.services.jobs.GetCurrentMoment;
import com.example.geoprocessingtest.geoprocessing.services.jobs.JobEntity;
import com.example.geoprocessingtest.geoprocessing.services.jobs.JobRepository;
import org.json.JSONObject;
import org.springframework.core.io.ResourceLoader;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class GeoProcessCircle extends GeoProcessingProcess {

    public GeoProcessCircle() {
        super("Calculate Circle Area",
                "Basic description",
                "CircleArea",
                "1.0",
                true);
        ArrayList<ParametersValue> parametersValues = new ArrayList<>();
        parametersValues.add(new ParametersValue("a", "2020-09-22T15:54:54.000", "Felipe"));
        this.getAdditionalParameters().getParameters().add(new Parameters("p1", parametersValues));

        this.getLinks().add( new GeoProcessingProcessLinks(
                this.getId(),
                "self",
                "application/json",
                "process description"
        ));

        this.getJobControlOptions().add("async-execute");

        this.getKeywords().add("Lorem");
        this.getKeywords().add("Ipsum");
        this.setInputs(new GenericJSON("{\"phonetype\":\"N95\",\"cat\":\"WP\"}"));
    }

    @Override
    public void execute(HttpServletRequest request, ResourceLoader resourceLoader, JobRepository jobRepository, JobEntity job, GenericJSON body) {
        JobEntity jobEntity = jobRepository.findJobEntityByJobID(job.getJobID());
        if (jobEntity != null) {
            // {inputs: {Circle: {radius: 3}}, response: "document"}
            JSONObject jsonObject = body.toJSONObject();
            JSONObject inputs = (JSONObject)jsonObject.get("inputs");
            JSONObject circle = (JSONObject)inputs.get("Circle");
            Double radius = ((Number) circle.get("radius")).doubleValue();
            System.out.println("Circle Radius: " + radius + ", Area: " + Math.PI * Math.pow(radius, 2) );
            jobEntity.setProgress(100L);
            jobEntity.setFinished(GetCurrentMoment.nowAsISO());
            jobEntity.setStatus("successful");
            jobRepository.save(jobEntity);
        }
    }
}
