package mocks;

import com.app.news.controller.model.request.EventsRequestUpdate;
import com.app.news.controller.model.request.LaunchesRequest;
import com.app.news.controller.model.request.LaunchesRequestUpdate;
import com.app.news.controller.model.request.NewsRequestUpdate;
import com.app.news.controller.model.response.EventsResponse;
import com.app.news.controller.model.response.NewsResponse;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NewsRequestUpdateMock {

    public static UUID uuid = UUID.fromString("e9186a58-12e9-460e-9ff9-d000630926b4");

    public static NewsRequestUpdate newsRequestUpdate() {
        NewsRequestUpdate newsRequestUpdate = new NewsRequestUpdate();
        newsRequestUpdate.setTitle("some title");
        newsRequestUpdate.setUrl("some url");
        newsRequestUpdate.setNewsSite("some new site");
        newsRequestUpdate.setFeatured(Boolean.FALSE);
        newsRequestUpdate.setPublishedAt(Timestamp.valueOf("2018-09-01 09:01:15"));
        newsRequestUpdate.setImageUrl("some image url");
        newsRequestUpdate.setSummary("some summary");
        newsRequestUpdate.setLaunches(launchesRequestUpdateList());
        newsRequestUpdate.setEvents(requestUpdateList());
        return newsRequestUpdate;
    }

    public static EventsRequestUpdate eventsRequestUpdate() {
        EventsRequestUpdate eventsRequestUpdate = new EventsRequestUpdate();
        eventsRequestUpdate.setEventsId(uuid);
        eventsRequestUpdate.setProvider("some provider");
        return eventsRequestUpdate;
    }

    public static List<EventsRequestUpdate> requestUpdateList() {
        List<EventsRequestUpdate> requestUpdates = new ArrayList<>();
        requestUpdates.add(eventsRequestUpdate());
        return requestUpdates;
    }

    public static LaunchesRequestUpdate launchesRequestUpdate() {
        LaunchesRequestUpdate launchesRequestUpdate = new LaunchesRequestUpdate();
        launchesRequestUpdate.setLaunchesId(uuid);
        launchesRequestUpdate.setProvider("some provider");
        return launchesRequestUpdate;
    }

    public static List<LaunchesRequestUpdate> launchesRequestUpdateList() {
        List<LaunchesRequestUpdate> requestUpdateList = new ArrayList<>();
        requestUpdateList.add(launchesRequestUpdate());
        return requestUpdateList;
    }
}
