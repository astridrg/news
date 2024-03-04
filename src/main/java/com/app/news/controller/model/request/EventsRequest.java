package com.app.news.controller.model.request;

public class EventsRequest {

    private String provider;

    public EventsRequest(String provider) {
        this.provider = provider;
    }

    public EventsRequest() {
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
