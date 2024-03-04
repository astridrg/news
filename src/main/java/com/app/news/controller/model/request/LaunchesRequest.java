package com.app.news.controller.model.request;

public class LaunchesRequest {

    private String provider;

    public LaunchesRequest(String provider) {
        this.provider = provider;
    }

    public LaunchesRequest() {
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
