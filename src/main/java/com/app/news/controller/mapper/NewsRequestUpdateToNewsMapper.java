package com.app.news.controller.mapper;

import com.app.news.controller.model.request.EventsRequestUpdate;
import com.app.news.controller.model.request.LaunchesRequestUpdate;
import com.app.news.controller.model.request.NewsRequestUpdate;
import com.app.news.domain.model.Events;
import com.app.news.domain.model.Launches;
import com.app.news.domain.model.News;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NewsRequestUpdateToNewsMapper {

    public News newsRequestUpdateToNews(NewsRequestUpdate newsRequestUpdate) {
        News news = new News();
        news.setImageUrl(newsRequestUpdate.getImageUrl());
        news.setNewsSite(newsRequestUpdate.getNewsSite());
        news.setFeatured(newsRequestUpdate.getFeatured());
        news.setSummary(newsRequestUpdate.getSummary());
        news.setTitle(newsRequestUpdate.getTitle());
        news.setUpdatedAt(newsRequestUpdate.getPublishedAt());
        news.setUrl(newsRequestUpdate.getUrl());
        news.setEvents(eventsRequestUpdateList(newsRequestUpdate.getEvents()));
        news.setLaunches(launchesRequestUpdateList(newsRequestUpdate.getLaunches()));
        return news;
    }

    public Events eventsRequestUpdate(EventsRequestUpdate eventsRequestUpdate) {
        Events events = new Events();
        events.setProvider(eventsRequestUpdate.getProvider());
        events.setEventId(eventsRequestUpdate.getEventsId());
        return events;
    }

    public List<Events> eventsRequestUpdateList(List<EventsRequestUpdate> eventsRequestUpdateList) {
        List<Events> eventsList = new ArrayList<>();
        for (EventsRequestUpdate eventsRequestUpdate : eventsRequestUpdateList) {
            eventsList.add(eventsRequestUpdate(eventsRequestUpdate));
        }
        return eventsList;
    }

    public Launches launchesRequestUpdate(LaunchesRequestUpdate launchesRequestUpdate) {
        Launches launches = new Launches();
        launches.setProvider(launchesRequestUpdate.getProvider());
        launches.setLaunchId(launchesRequestUpdate.getLaunchesId());
        return launches;
    }

    public List<Launches> launchesRequestUpdateList(List<LaunchesRequestUpdate> requestUpdateList) {
        List<Launches> launchesList = new ArrayList<>();
        for (LaunchesRequestUpdate launchesRequestUpdate : requestUpdateList) {
            launchesList.add(launchesRequestUpdate(launchesRequestUpdate));
        }
        return launchesList;
    }

}
