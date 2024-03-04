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
public class NewsToNewsEntityMapper {

    public NewsEntity newsToNewsEntity(News news){
        NewsEntity newsEntity = new NewsEntity();
        newsEntity.setNewsSite(news.getNewsSite());
        newsEntity.setFeatured(news.getFeatured());
        newsEntity.setImageUrl(news.getImageUrl());
        newsEntity.setSummary(news.getSummary());
        newsEntity.setUrl(news.getUrl());
        newsEntity.setTitle(news.getTitle());
        newsEntity.setUpdatedAt(news.getUpdatedAt());
        newsEntity.setPublishedAt(news.getPublishedAt());
        newsEntity.setId(news.getId());
        newsEntity.setLaunches(launchesEntityList(news.getLaunches(), newsEntity));
        newsEntity.setEvents(eventsEntityList(news.getEvents(),newsEntity));
        return newsEntity;
    }

    public NewsEntity newsMerge(News news, NewsEntity newsEntity){
        newsEntity.setNewsSite(news.getNewsSite());
        newsEntity.setFeatured(news.getFeatured());
        newsEntity.setImageUrl(news.getImageUrl());
        newsEntity.setSummary(news.getSummary());
        newsEntity.setUrl(news.getUrl());
        newsEntity.setTitle(news.getTitle());
        newsEntity.setUpdatedAt(news.getUpdatedAt());
        newsEntity.setPublishedAt(news.getPublishedAt());
        newsEntity.setLaunches(launchesListMerge(news.getLaunches(), newsEntity.getLaunches()));
        newsEntity.setEvents(evensListMerge(news.getEvents(), newsEntity.getEvents()));
        return newsEntity;
    }

    public EventsEntity eventsMerge(Events events, EventsEntity eventsEntity){
        eventsEntity.setId(events.getEventId());
        eventsEntity.setProvider(events.getProvider());
        return eventsEntity;
    }

    public List<LaunchesEntity> launchesListMerge(List<Launches> launchesList, List<LaunchesEntity> launchesEntityList){
        for (Launches launches : launchesList ) {
            LaunchesEntity launchesEntity = launchesEntityList.stream()
                    .filter((LaunchesEntity e) -> e.getId().equals(launches.getLaunchId())).findFirst().get();
            launchesEntityList.add(launchesMerge(launches,launchesEntity ));
        }
        return launchesEntityList;
    }


    public LaunchesEntity launchesMerge(Launches launches, LaunchesEntity launchesEntity){
        launchesEntity.setId(launches.getLaunchId());
        launchesEntity.setProvider(launches.getProvider());
        return launchesEntity;
    }

    public List<EventsEntity> evensListMerge(List<Events> eventsList, List<EventsEntity> eventsEntityList){
        for (Events events : eventsList ) {
            EventsEntity eventsMerge = eventsEntityList.stream()
                    .filter((EventsEntity e) -> e.getId().equals(events.getEventId())).findFirst().get();
            eventsEntityList.add(eventsMerge(events,  eventsMerge));
        }
        return eventsEntityList;
    }

    public EventsEntity eventsEntity(Events events, NewsEntity newsEntity){
        EventsEntity eventsEntity = new EventsEntity();
        eventsEntity.setProvider(events.getProvider());
        eventsEntity.setId(events.getEventId());
        eventsEntity.setNews(newsEntity);
        return eventsEntity;
    }

    public List<EventsEntity> eventsEntityList(List<Events> eventsList,NewsEntity newsEntity ){
        List<EventsEntity> entityList = new ArrayList<>();
        for (Events events : eventsList ) {
            entityList.add(eventsEntity(events,newsEntity ));
        }
        return entityList;
    }

    public LaunchesEntity launchesEntity(Launches launches, NewsEntity newsEntity){
        LaunchesEntity launchesEntity = new LaunchesEntity();
        launchesEntity.setProvider(launches.getProvider());
        launchesEntity.setId(launches.getLaunchId());
        launchesEntity.setNews(newsEntity);
        return launchesEntity;
    }

    public List<LaunchesEntity> launchesEntityList(List<Launches> launchesList,NewsEntity newsEntity ){
        List<LaunchesEntity> entityList = new ArrayList<>();
        for (Launches launches : launchesList ) {
            entityList.add(launchesEntity(launches, newsEntity));
        }
        return entityList;
    }
}
