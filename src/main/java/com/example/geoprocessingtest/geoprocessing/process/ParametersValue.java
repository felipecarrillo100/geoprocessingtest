package com.example.geoprocessingtest.geoprocessing.process;

public class ParametersValue {
    private String type;
    private String publishDate;
    private String publisher;

    public ParametersValue(String type, String publishDate, String publisher) {
        this.type = type;
        this.publishDate = publishDate;
        this.publisher = publisher;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
