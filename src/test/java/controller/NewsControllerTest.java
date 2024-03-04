package controller;

import com.app.news.controller.NewsController;
import com.app.news.controller.mapper.NewToNewsResponseMapper;
import com.app.news.controller.mapper.NewsRequestUpdateToNewsMapper;
import com.app.news.controller.mapper.NewsToNewsRequestMapper;
import com.app.news.controller.model.request.NewsRequest;
import com.app.news.controller.model.request.NewsRequestUpdate;
import com.app.news.controller.model.response.NewsResponse;
import com.app.news.domain.model.News;
import com.app.news.domain.port.in.NewsIn;
import mocks.NewsMock;
import mocks.NewsRequestMock;
import mocks.NewsRequestUpdateMock;
import mocks.NewsResponseMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class NewsControllerTest {

    @Mock
    private NewsIn newsIn;
    @Mock
    private NewsToNewsRequestMapper newsToNewsRequestMapper;
    @Mock
    private NewToNewsResponseMapper newToNewsResponseMapper;
    @Mock
    private NewsRequestUpdateToNewsMapper newsRequestUpdateToNewsMapper;

    private NewsController newsController;

    @BeforeEach
    public void init(){
        newsController = new NewsController(newsIn, newsToNewsRequestMapper,
                newToNewsResponseMapper, newsRequestUpdateToNewsMapper);
    }

    public static UUID uuid = UUID.fromString("e9186a58-12e9-460e-9ff9-d000630926b4");

    @Test
    public void createNewsTest() {
        News newsMock = NewsMock.news();
        NewsRequest newsRequestMock = NewsRequestMock.newsRequest();
        NewsResponse newsResponseMock = NewsResponseMock.newsResponse();

        Mockito.when(newsToNewsRequestMapper.newsRequestToNews(newsRequestMock)).thenReturn(newsMock);
        Mockito.when(newsIn.saveNews(newsMock)).thenReturn(newsMock);
        Mockito.when(newToNewsResponseMapper.newsToNewsResponse(newsMock)).thenReturn(newsResponseMock);
        ResponseEntity<NewsResponse> userRequestMethodMock =
                newsController.createNews(newsRequestMock);

        Mockito.verify(newsIn, Mockito.times(1)).saveNews(newsMock);

        assertThat(userRequestMethodMock.getBody())
               .usingRecursiveComparison()
                .isEqualTo(newsResponseMock);
    }

    @Test
    public void getNewsByIdTest() {
        News newsMock = NewsMock.news();
        NewsResponse newsResponseMock = NewsResponseMock.newsResponse();

        Mockito.when(newsIn.getNewsById(newsMock.getId())).thenReturn(newsMock);
        Mockito.when(newToNewsResponseMapper.newsToNewsResponse(newsMock)).thenReturn(newsResponseMock);
        ResponseEntity<NewsResponse> userRequestMethodMock =
                newsController.getNewsById(newsResponseMock.getId());

        Mockito.verify(newsIn, Mockito.times(1)).getNewsById(newsMock.getId());
        assertThat(userRequestMethodMock.getBody())
                .usingRecursiveComparison()
                .isEqualTo(newsResponseMock);
    }

    @Test
    public void getNewsByTitleTest() {
        News newsMock = NewsMock.news();
        NewsResponse newsResponseMock = NewsResponseMock.newsResponse();

        Mockito.when(newsIn.getNewsByTitle(newsMock.getTitle())).thenReturn(newsMock);
        Mockito.when(newToNewsResponseMapper.newsToNewsResponse(newsMock)).thenReturn(newsResponseMock);
        ResponseEntity <NewsResponse> userRequestMethodMock =
                newsController.getNewsByTitle(newsResponseMock.getTitle());

        Mockito.verify(newsIn, Mockito.times(1)).getNewsByTitle(newsMock.getTitle());
        assertThat(userRequestMethodMock.getBody())
                .usingRecursiveComparison()
                .isEqualTo(newsResponseMock);
    }

    @Test
    public void getListNewsTest() {
        List<News> newsMock = NewsMock.newsList();
        List<NewsResponse> newsResponseMock = NewsResponseMock.newsResponseList();

        Mockito.when(newsIn.getListNews()).thenReturn(newsMock);
        Mockito.when(newToNewsResponseMapper.newsResponseList(newsMock)).thenReturn(newsResponseMock);
        ResponseEntity<List<NewsResponse>> userRequestMethodMock =
                newsController.getListNews();

        assertThat(userRequestMethodMock.getBody())
                .usingRecursiveComparison()
                .isEqualTo(newsResponseMock);
    }

    @Test
    public void deleteNewsById() {
        News newsMock = NewsMock.news();

        Mockito.doNothing().when(newsIn).deleteNewsById(newsMock.getId());
        ResponseEntity userRequestMethodMock =
                newsController.deleteNewsById(newsMock.getId());

        Mockito.verify(newsIn, Mockito.times(1)).deleteNewsById(newsMock.getId());
        Assertions.assertEquals(userRequestMethodMock.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void updateNewsTest() {
        News newsMock = NewsMock.news();
        NewsRequestUpdate newsRequestUpdate = NewsRequestUpdateMock.newsRequestUpdate();
        NewsResponse newsResponseMock = NewsResponseMock.newsResponse();

        Mockito.when(newsRequestUpdateToNewsMapper.newsRequestUpdateToNews(newsRequestUpdate)).thenReturn(newsMock);
        Mockito.when(newsIn.updateNews(newsMock.getId(), newsMock)).thenReturn(newsMock);
        Mockito.when(newToNewsResponseMapper.newsToNewsResponse(newsMock)).thenReturn(newsResponseMock);
        ResponseEntity<NewsResponse> userRequestMethodMock =
                newsController.updateNews(uuid,newsRequestUpdate);

        Mockito.verify(newsIn, Mockito.times(1)).updateNews(uuid, newsMock );
    }
}
