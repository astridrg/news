package mocks;

import com.app.news.domain.model.News;
import com.app.news.repository.model.EventsEntity;
import com.app.news.repository.model.LaunchesEntity;
import com.app.news.repository.model.NewsEntity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NewsEntityMock {

    public static UUID uuid = UUID.fromString("e9186a58-12e9-460e-9ff9-d000630926b4");

    public static NewsEntity newsEntity() {
        NewsEntity newsEntity = new NewsEntity();
        newsEntity.setId(uuid);
        newsEntity.setFeatured(Boolean.FALSE);
        newsEntity.setTitle("some title");
        newsEntity.setNewsSite("some new site");
        newsEntity.setUrl("some url");
        newsEntity.setSummary("some summary");
        newsEntity.setImageUrl("some image url");
        newsEntity.setPublishedAt(Timestamp.valueOf("2018-09-01 09:01:15"));
        newsEntity.setUpdatedAt(Timestamp.valueOf("2018-09-01 09:01:15"));
        newsEntity.setEvents(eventsEntityList());
        newsEntity.setLaunches(launchesEntityList());
        return newsEntity;
    }

    public static List<NewsEntity> newsEntityList() {
        List<NewsEntity> newsEntityList = new ArrayList<>();
        newsEntityList.add(newsEntity());
        return newsEntityList;
    }

    public static EventsEntity eventsEntity() {
        EventsEntity eventsEntity = new EventsEntity();
        eventsEntity.setId(uuid);
        eventsEntity.setProvider("some provider");
        return eventsEntity;
    }

    public static List<EventsEntity> eventsEntityList() {
        List<EventsEntity> entityList = new ArrayList<>();
        entityList.add(eventsEntity());
        return entityList;
    }

    public static LaunchesEntity launchesEntity() {
        LaunchesEntity launchesEntity = new LaunchesEntity();
        launchesEntity.setId(uuid);
        launchesEntity.setProvider("some provider");
        return launchesEntity;
    }

    public static List<LaunchesEntity> launchesEntityList() {
        List<LaunchesEntity> launchesEntities = new ArrayList<>();
        launchesEntities.add(launchesEntity());
        return launchesEntities;
    }
}
