package com.example.geoprocessingtest.geoprocessing.process;

public class GeoProcessingProcessLinks {
    private String href;
    private String rel;
    private String type;
    private String title;

    public GeoProcessingProcessLinks(String href, String rel, String type, String title) {
        this.href = href;
        this.rel = rel;
        this.type = type;
        this.title = title;
    }

    public GeoProcessingProcessLinks clone() {
        return new GeoProcessingProcessLinks(this.getHref(), this.getRel(), this.getType(), this.getTitle());
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
