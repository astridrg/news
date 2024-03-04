package com.app.news.controller.model.request;

import java.sql.Timestamp;
import java.util.List;

public class NewsRequestUpdate {

    private String title;

    private String url;

    private String imageUrl;

    private String newsSite;

    private String summary;

    private Timestamp publishedAt;

    private Boolean featured;

    private List<LaunchesRequestUpdate> launches;

    private List<EventsRequestUpdate> events;

    public NewsRequestUpdate(String title, String url, String imageUrl, String newsSite, String summary, Timestamp publishedAt, Boolean featured, List<LaunchesRequestUpdate> launches, List<EventsRequestUpdate> events) {
        this.title = title;
        this.url = url;
        this.imageUrl = imageUrl;
        this.newsSite = newsSite;
        this.summary = summary;
        this.publishedAt = publishedAt;
        this.featured = featured;
        this.launches = launches;
        this.events = events;
    }

    public NewsRequestUpdate() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNewsSite() {
        return newsSite;
    }

    public void setNewsSite(String newsSite) {
        this.newsSite = newsSite;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Timestamp getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Timestamp publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public List<LaunchesRequestUpdate> getLaunches() {
        return launches;
    }

    public void setLaunches(List<LaunchesRequestUpdate> launches) {
        this.launches = launches;
    }

    public List<EventsRequestUpdate> getEvents() {
        return events;
    }

    public void setEvents(List<EventsRequestUpdate> events) {
        this.events = events;
    }
}
