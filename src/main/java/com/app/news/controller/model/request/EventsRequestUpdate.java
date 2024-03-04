package com.app.news.controller.model.request;

import java.util.UUID;

public class EventsRequestUpdate {

    private String provider;
    private UUID eventsId;

    public EventsRequestUpdate(String provider, UUID eventsId) {
        this.provider = provider;
        this.eventsId = eventsId;
    }

    public EventsRequestUpdate() {
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public UUID getEventsId() {
        return eventsId;
    }

    public void setEventsId(UUID eventsId) {
        this.eventsId = eventsId;
    }
}
