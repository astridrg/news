package com.app.news.controller.mapper;

import com.app.news.controller.model.response.EventsResponse;
import com.app.news.controller.model.response.LaunchesResponse;
import com.app.news.controller.model.response.NewsResponse;
import com.app.news.domain.model.Events;
import com.app.news.domain.model.Launches;
import com.app.news.domain.model.News;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NewToNewsResponseMapper {

    public List<NewsResponse> newsResponseList(List<News> newsList){
        List<NewsResponse> newsResponseList = new ArrayList<>();
        for (News news:newsList) {
            newsResponseList.add(newsToNewsResponse(news));
        }
        return newsResponseList;
    }

    public NewsResponse newsToNewsResponse(News news){
        NewsResponse newsResponse = new NewsResponse();
        newsResponse.setNewsSite(news.getNewsSite());
        newsResponse.setFeatured(news.getFeatured());
        newsResponse.setImageUrl(news.getImageUrl());
        newsResponse.setPublishedAt(news.getPublishedAt());
        newsResponse.setSummary(news.getSummary());
        newsResponse.setTitle(news.getTitle());
        newsResponse.setUpdatedAt(news.getUpdatedAt());
        newsResponse.setUrl(news.getUrl());
        newsResponse.setId(news.getId());
        newsResponse.setEvents(eventsResponseList(news.getEvents()));
        newsResponse.setLaunches(launchesResponseList(news.getLaunches()));
        return newsResponse;
    }

    public LaunchesResponse launchesResponse(Launches launches){
        LaunchesResponse launchesResponse = new LaunchesResponse();
        launchesResponse.setLaunchId(launches.getLaunchId());
        launchesResponse.setProvider(launches.getProvider());
        return launchesResponse;
    }

    public List<LaunchesResponse> launchesResponseList(List<Launches> launchesList){
        List<LaunchesResponse> responseList = new ArrayList<>();
        for (Launches launches: launchesList) {
            responseList.add(launchesResponse(launches));
        }
        return responseList;
    }

    public EventsResponse eventsResponse(Events events){
        EventsResponse eventsResponse = new EventsResponse();
        eventsResponse.setEventId(events.getEventId());
        eventsResponse.setProvider(events.getProvider());
        return eventsResponse;

    }

    public List<EventsResponse> eventsResponseList(List<Events> eventsList){
        List<EventsResponse> responseList = new ArrayList<>();
        for (Events events : eventsList) {
            responseList.add(eventsResponse(events));
        }
        return responseList;
    }

}