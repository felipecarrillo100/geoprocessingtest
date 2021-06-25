package com.example.geoprocessingtest.geoprocessing.process;

import com.example.geoprocessingtest.geoprocessing.process.lib.GeoProcessBasic;
import com.example.geoprocessingtest.geoprocessing.process.lib.GeoProcessCircle;
import com.example.geoprocessingtest.geoprocessing.process.lib.GeoProcessLocation;
import com.example.geoprocessingtest.geoprocessing.process.lib.GeoProcessLocationEPSG;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("ProcessBuilder")
public class ProcessBuilder {
    List<GeoProcessingProcess> list = new ArrayList<GeoProcessingProcess>();

    public ProcessBuilder(List<GeoProcessingProcess> result) {
        build();
    }

    private void build() {
        list.add(new GeoProcessBasic());
        list.add(new GeoProcessCircle());
        list.add(new GeoProcessLocation());
        list.add(new GeoProcessLocationEPSG());
    }

    public List<GeoProcessingProcess> getResults() {
        return list;
    }

    public List<GeoProcessingProcessSimplified> getResultsSimplified() {
        List<GeoProcessingProcessSimplified> result = new ArrayList<GeoProcessingProcessSimplified>();

        for(GeoProcessingProcess p : list) {
            result.add(new GeoProcessingProcessSimplified(p));
        }

        return result;
    }

    public GeoProcessingProcess findProcessByID(String id) {
        GeoProcessingProcess process = list.stream()
                .filter(p -> id.equals(p.getId()))
                .findAny()
                .orElse(null);
        if (process == null) return null;
        return process;
    }

}
