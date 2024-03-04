package com.app.news.controller.model.response;

import java.util.UUID;

public class LaunchesResponse {

    private UUID launchId;

    private String provider;

    public LaunchesResponse(UUID launchId, String provider) {
        this.launchId = launchId;
        this.provider = provider;
    }

    public LaunchesResponse() {
    }

    public UUID getLaunchId() {
        return launchId;
    }

    public void setLaunchId(UUID launchId) {
        this.launchId = launchId;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
