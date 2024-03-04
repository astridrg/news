package com.app.news.controller.mapper;

import com.app.news.controller.model.request.EventsRequest;
import com.app.news.controller.model.request.LaunchesRequest;
import com.app.news.controller.model.request.NewsRequest;
import com.app.news.domain.model.Events;
import com.app.news.domain.model.Launches;
import com.app.news.domain.model.News;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NewsToNewsRequestMapper {

    public News newsRequestToNews(NewsRequest newsRequest) {
        News news = new News();
        news.setImageUrl(newsRequest.getImageUrl());
        news.setNewsSite(newsRequest.getNewsSite());
        news.setPublishedAt(newsRequest.getPublishedAt());
        news.setFeatured(newsRequest.getFeatured());
        news.setSummary(newsRequest.getSummary());
        news.setTitle(newsRequest.getTitle());
        news.setUpdatedAt(newsRequest.getUpdatedAt());
        news.setUrl(newsRequest.getUrl());
        news.setEvents(listEventsRequestToListEvents(newsRequest.getEvents()));
        news.setLaunches(listLaunchesRequestToListLaunches(newsRequest.getLaunches()));
       return news;
    }

    public Events eventsRequestToEvents(EventsRequest eventsRequest){
        Events events = new Events();
        events.setProvider(eventsRequest.getProvider());
        return events;
    }

    public List<Events> listEventsRequestToListEvents(List<EventsRequest> eventsRequestList){
        List<Events> eventsList = new ArrayList<>();
        for (EventsRequest eventsRequest :eventsRequestList ){
            eventsList.add(eventsRequestToEvents(eventsRequest));
        }
        return eventsList;
    }

    public Launches launchesRequestToLaunches(LaunchesRequest launchesRequest){
        Launches launches = new Launches();
        launches.setProvider(launchesRequest.getProvider());
        return launches;
    }

    public List<Launches> listLaunchesRequestToListLaunches(List<LaunchesRequest> launchesRequestList){
        List<Launches> launchesList = new ArrayList<>();
        for (LaunchesRequest launchesRequest : launchesRequestList){
            launchesList.add(launchesRequestToLaunches(launchesRequest));
        }
        return launchesList;
    }
}
