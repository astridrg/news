package com.app.news.domain.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public class News {

    private UUID id;

    private String title;

    private String url;

    private String imageUrl;

    private String newsSite;

    private String summary;

    private Timestamp publishedAt;

    private Timestamp updatedAt;

    private Boolean featured;

    private List<Events> events;

    private List<Launches> launches;

    public News(UUID id, String title, String url, String imageUrl, String newsSite, String summary, Timestamp publishedAt, Timestamp updatedAt, Boolean featured, List<Events> events, List<Launches> launches) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.imageUrl = imageUrl;
        this.newsSite = newsSite;
        this.summary = summary;
        this.publishedAt = publishedAt;
        this.updatedAt = updatedAt;
        this.featured = featured;
        this.events = events;
        this.launches = launches;
    }

    public News() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public List<Events> getEvents() {
        return events;
    }

    public void setEvents(List<Events> events) {
        this.events = events;
    }

    public List<Launches> getLaunches() {
        return launches;
    }

    public void setLaunches(List<Launches> launches) {
        this.launches = launches;
    }
}
