package com.app.news.controller.model.response;

import java.util.UUID;

public class EventsResponse {

    private UUID eventId;

    private String provider;

    public EventsResponse(UUID eventId, String provider) {
        this.eventId = eventId;
        this.provider = provider;
    }

    public EventsResponse() {
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
