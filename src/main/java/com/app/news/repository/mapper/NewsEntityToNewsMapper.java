package com.app.news.repository.mapper;

import com.app.news.domain.model.Events;
import com.app.news.domain.model.Launches;
import com.app.news.domain.model.News;
import com.app.news.repository.model.EventsEntity;
import com.app.news.repository.model.LaunchesEntity;
import com.app.news.repository.model.NewsEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NewsEntityToNewsMapper {

    public List<News> listNewsEntityToListNews(List<NewsEntity> newsEntityList){
        List<News> newsList = new ArrayList<>();
        for (NewsEntity newsEntity:newsEntityList) {
            newsList.add(newsEntityToNews(newsEntity));
        }
        return newsList;
    }

    public News newsEntityToNews(NewsEntity newsEntity){
        News news = new News();
        news.setNewsSite(newsEntity.getNewsSite());
        news.setFeatured(newsEntity.getFeatured());
        news.setImageUrl(newsEntity.getImageUrl());
        news.setSummary(newsEntity.getSummary());
        news.setUrl(newsEntity.getUrl());
        news.setTitle(newsEntity.getTitle());
        news.setUpdatedAt(newsEntity.getUpdatedAt());
        news.setPublishedAt(newsEntity.getPublishedAt());
        news.setId(newsEntity.getId());
        news.setLaunches(launchesList(newsEntity.getLaunches()));
        news.setEvents(eventsList(newsEntity.getEvents()));
        return news;
    }

    public Events events(EventsEntity eventsEntity){
        Events events = new Events();
        events.setProvider(eventsEntity.getProvider());
        events.setEventId(eventsEntity.getId());
        return events;
    }

    public List<Events> eventsList(List<EventsEntity> eventsEntityList){
        List<Events> eventsList = new ArrayList<>();
        for (EventsEntity eventsEntity : eventsEntityList ) {
            eventsList.add(events(eventsEntity));
        }
        return eventsList;
    }

    public Launches launches(LaunchesEntity launchesEntity){
        Launches launches = new Launches();
        launches.setProvider(launchesEntity.getProvider());
        launches.setLaunchId(launchesEntity.getId());
        return launches;
    }

    public List<Launches> launchesList(List<LaunchesEntity> launchesEntityList){
        List<Launches> launchesList = new ArrayList<>();
        for (LaunchesEntity launchesEntity : launchesEntityList ) {
            launchesList.add(launches(launchesEntity));
        }
        return launchesList;
    }
}
