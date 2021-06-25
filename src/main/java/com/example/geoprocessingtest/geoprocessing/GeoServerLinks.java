package com.example.geoprocessingtest.geoprocessing;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class GeoServerLinks {
    private List<GeoServerLink> links;

    public GeoServerLinks() {
        this.links = new ArrayList<GeoServerLink>();
    }

    public GeoServerLinks(HttpServletRequest request) {
        this.links = new ArrayList<GeoServerLink>();
        this.add( new GeoServerLink(request.getRequestURL().toString(), "self","application/json", "en","This document"));
        this.add( new GeoServerLink(request.getRequestURL().toString() + "api", "service-desc","application/json", "en","API definition for this endpoint as JSON"));
        this.add( new GeoServerLink(request.getRequestURL().toString() + "conformance", "conformance","application/json", "en","OGC API - Processes conformance classes implemented by this server"));
        this.add( new GeoServerLink(request.getRequestURL().toString() + "processes", "processes","application/json", "en","Metadata about the processes"));
        this.add( new GeoServerLink(request.getRequestURL().toString() + "jobs", "jobs","application/json", "en","The endpoint for job monitoring"));
    }

    public GeoServerLinks(List<GeoServerLink> gl) {
        this.links = gl;
    }

    public void add(GeoServerLink link) {
        this.links.add(link);
    }

    public List getLinks() {
        return links;
    }

    public void setLinks(List links) {
        this.links = links;
    }
}
