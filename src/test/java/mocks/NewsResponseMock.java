package mocks;

import com.app.news.controller.model.response.EventsResponse;
import com.app.news.controller.model.response.LaunchesResponse;
import com.app.news.controller.model.response.NewsResponse;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NewsResponseMock {

    public static UUID uuid = UUID.fromString("e9186a58-12e9-460e-9ff9-d000630926b4");

    public static List<NewsResponse> newsResponseList() {
        List<NewsResponse> newsResponses = new ArrayList<>();
        newsResponses.add(newsResponse());
        return newsResponses;
    }

    public static NewsResponse newsResponse() {
        NewsResponse newsResponse = new NewsResponse();
        newsResponse.setId(uuid);
        newsResponse.setTitle("some title");
        newsResponse.setUrl("some url");
        newsResponse.setNewsSite("some new site");
        newsResponse.setFeatured(Boolean.FALSE);
        newsResponse.setPublishedAt(Timestamp.valueOf("2018-09-01 09:01:15"));
        newsResponse.setUpdatedAt(Timestamp.valueOf("2018-09-01 09:01:15"));
        newsResponse.setImageUrl("some image url");
        newsResponse.setSummary("some summary");
        newsResponse.setLaunches(launchesResponseList());
        newsResponse.setEvents(eventsResponseList());
        return newsResponse;
    }

    public static EventsResponse eventsResponse() {
        EventsResponse eventsResponse = new EventsResponse();
        eventsResponse.setEventId(uuid);
        eventsResponse.setProvider("some provider");
        return eventsResponse;
    }

    public static List<EventsResponse> eventsResponseList() {
        List<EventsResponse> responseList = new ArrayList<>();
        responseList.add(eventsResponse());
        return responseList;
    }

    public static LaunchesResponse launchesResponse() {
        LaunchesResponse launchesResponse = new LaunchesResponse();
        launchesResponse.setLaunchId(uuid);
        launchesResponse.setProvider("some provider");
        return launchesResponse;
    }

    public static List<LaunchesResponse> launchesResponseList() {
        List<LaunchesResponse> responseList = new ArrayList<>();
        responseList.add(launchesResponse());
        return responseList;
    }

}
