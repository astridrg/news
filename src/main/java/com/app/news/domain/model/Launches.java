package com.app.news.domain.model;

import java.util.UUID;

public class Launches {

    private UUID launchId;

    private String provider;

    public Launches(UUID launchId, String provider) {
        this.launchId = launchId;
        this.provider = provider;
    }

    public Launches() {
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
