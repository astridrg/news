package com.app.news.domain.model;

import java.util.UUID;

public class Events {

    private UUID eventId;

    private String provider;

    public Events(UUID eventId, String provider) {
        this.eventId = eventId;
        this.provider = provider;
    }

    public Events() {
    }

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
