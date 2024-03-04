package mocks;

import com.app.news.domain.model.Events;
import com.app.news.domain.model.Launches;
import com.app.news.domain.model.News;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NewsMock {

    public static UUID uuid = UUID.fromString("e9186a58-12e9-460e-9ff9-d000630926b4");

    public static News news() {
        News news = new News();
        news.setId(uuid);
        news.setTitle("some title");
        news.setUrl("some url");
        news.setNewsSite("some new site");
        news.setFeatured(Boolean.FALSE);
        news.setImageUrl("some image url");
        news.setSummary("some summary");
        news.setPublishedAt(Timestamp.valueOf("2018-09-01 09:01:15"));
        news.setUpdatedAt(Timestamp.valueOf("2018-09-01 09:01:15"));
        news.setLaunches(launchesList());
        news.setEvents(eventsList());
        return news;
    }


    public static List<News> newsList() {
        List<News> news = new ArrayList<>();
        news.add(news());
        return news;
    }

    public static Events events() {
        Events events = new Events();
        events.setEventId(uuid);
        events.setProvider("some provider");
        return events;
    }

    public static List<Events> eventsList() {
        List<Events> responseList = new ArrayList<>();
        responseList.add(events());
        return responseList;
    }

    public static Launches launches() {
        Launches launches = new Launches();
        launches.setLaunchId(uuid);
        launches.setProvider("some provider");
        return launches;
    }

    public static List<Launches> launchesList() {
        List<Launches> responseList = new ArrayList<>();
        responseList.add(launches());
        return responseList;
    }
}
