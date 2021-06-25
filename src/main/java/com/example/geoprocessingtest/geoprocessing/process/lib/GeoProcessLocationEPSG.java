package com.example.geoprocessingtest.geoprocessing.process.lib;

import com.example.geoprocessingtest.geoprocessing.process.*;

import java.util.ArrayList;

public class GeoProcessLocationEPSG extends GeoProcessingProcess {

    public GeoProcessLocationEPSG() {
        super("Location with EPSG",
                "Enter Location longitude/latitude",
                "LocationEPSG",
                "1.0",
                true);
        ArrayList<ParametersValue> parametersValues = new ArrayList<>();
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
