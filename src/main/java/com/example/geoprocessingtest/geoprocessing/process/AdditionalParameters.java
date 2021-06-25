package com.example.geoprocessingtest.geoprocessing.process;

import java.util.ArrayList;
import java.util.List;

public class AdditionalParameters {
    private List<Parameters> parameters;

    public AdditionalParameters() {
        this.parameters = new ArrayList<Parameters>();
    }

    public AdditionalParameters(List<Parameters> parameters) {
        this.parameters = parameters;
    }

    public List<Parameters> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameters> parameters) {
        this.parameters = parameters;
    }
}
