package com.app.news.controller.model.request;

import java.util.UUID;

public class LaunchesRequestUpdate {

    private String provider;
    private UUID launchesId;

    public LaunchesRequestUpdate(String provider, UUID launchesId) {
        this.provider = provider;
        this.launchesId = launchesId;
    }

    public LaunchesRequestUpdate() {
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public UUID getLaunchesId() {
        return launchesId;
    }

    public void setLaunchesId(UUID launchesId) {
        this.launchesId = launchesId;
    }
}
