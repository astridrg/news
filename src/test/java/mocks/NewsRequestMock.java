package mocks;

import com.app.news.controller.model.request.EventsRequest;
import com.app.news.controller.model.request.LaunchesRequest;
import com.app.news.controller.model.request.NewsRequest;
import java.util.ArrayList;
import java.util.List;

public class NewsRequestMock {

    public static NewsRequest newsRequest() {
        NewsRequest newsRequest = new NewsRequest();
        newsRequest.setTitle("some title");
        newsRequest.setUrl("some url");
        newsRequest.setNewsSite("some new site");
        newsRequest.setFeatured(Boolean.FALSE);
        newsRequest.setImageUrl("some image url");
        newsRequest.setSummary("some summary");
        newsRequest.setLaunches(launchesRequestList());
        newsRequest.setEvents(eventsRequestList());
        return newsRequest;
    }

    public static EventsRequest eventsRequest() {
        EventsRequest eventsRequest = new EventsRequest();
        eventsRequest.setProvider("some provider");
        return eventsRequest;
    }

    public static List<EventsRequest> eventsRequestList() {
        List<EventsRequest> eventsRequestList = new ArrayList<>();
        eventsRequestList.add(eventsRequest());
        return eventsRequestList;
    }

    public static LaunchesRequest launchesRequest() {
        LaunchesRequest launchesRequest = new LaunchesRequest();
        launchesRequest.setProvider("some provider");
        return launchesRequest;
    }

    public static List<LaunchesRequest> launchesRequestList() {
        List<LaunchesRequest> launchesRequests = new ArrayList<>();
        launchesRequests.add(launchesRequest());
        return launchesRequests;
    }


}
