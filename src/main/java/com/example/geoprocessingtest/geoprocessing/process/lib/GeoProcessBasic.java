package com.example.geoprocessingtest.geoprocessing.process.lib;

import com.example.geoprocessingtest.geoprocessing.process.*;
import com.example.geoprocessingtest.geoprocessing.services.jobs.GetCurrentMoment;
import com.example.geoprocessingtest.geoprocessing.services.jobs.JobEntity;
import com.example.geoprocessingtest.geoprocessing.services.jobs.JobRepository;
import org.json.JSONObject;
import org.springframework.core.io.ResourceLoader;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class GeoProcessBasic extends GeoProcessingProcess {

    public GeoProcessBasic() {
        super("Enter Windows File with options",
                "Sample of Filename",
                "Basic",
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

}
