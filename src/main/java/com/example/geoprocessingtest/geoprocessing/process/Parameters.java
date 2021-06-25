package com.example.geoprocessingtest.geoprocessing.process;

import java.util.List;

public class Parameters {
    private String name;
    private List<ParametersValue> value;

    public Parameters(String name, List<ParametersValue> value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ParametersValue> getValue() {
        return value;
    }

    public void setValue(List<ParametersValue> value) {
        this.value = value;
    }
}
