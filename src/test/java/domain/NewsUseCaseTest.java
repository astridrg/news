package domain;

import com.app.news.domain.model.News;
import com.app.news.domain.port.out.NewsOut;
import com.app.news.domain.usecase.NewsUseCase;
import mocks.NewsMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class NewsUseCaseTest {

    @Mock
    private NewsOut newsOut;

    private NewsUseCase newsUseCase;

    @BeforeEach
    public void init(){
        newsUseCase = new NewsUseCase(newsOut);
    }

    @Test
    public void saveNewsTest(){
        News newsMock = NewsMock.news();

        Mockito.when(newsOut.saveNews(newsMock)).thenReturn(newsMock);
        News news = newsUseCase.saveNews(newsMock);

        Assertions.assertEquals(news,newsMock);
    }

    @Test
    public void getListNewsTest(){
        List<News> newsList = NewsMock.newsList();
        Mockito.when(newsOut.getListNews()).thenReturn(newsList);
        List<News> news = newsUseCase.getListNews();

        Assertions.assertEquals(news,newsList);
    }

    @Test
    public void getNewsByTitleTest(){
        News newsMock = NewsMock.news();

        Mockito.when(newsOut.getNewsByTitle(newsMock.getTitle())).thenReturn(newsMock);
        News news = newsUseCase.getNewsByTitle(newsMock.getTitle());

        Assertions.assertEquals(news,newsMock);
    }

    @Test
    public void deleteNewsByIdTest(){
        News newsMock = NewsMock.news();

        Mockito.doNothing().when(newsOut).deleteNewsById(newsMock.getId());
        newsUseCase.deleteNewsById(newsMock.getId());
        Mockito.verify(newsOut, Mockito.times(1)).deleteNewsById(newsMock.getId());
    }

    @Test
    public void getNewsByIdTest(){
        News newsMock = NewsMock.news();

        Mockito.when(newsOut.getNewsById(newsMock.getId())).thenReturn(newsMock);
        News news = newsUseCase.getNewsById(newsMock.getId());

        Assertions.assertEquals(news,newsMock);
    }

    @Test
    public void updateNewsTest(){
        News newsMock = NewsMock.news();

        Mockito.when(newsOut.updateNews(newsMock.getId(), newsMock)).thenReturn(newsMock);
        News news = newsUseCase.updateNews(newsMock.getId(), newsMock);

        Assertions.assertEquals(news,newsMock);
    }

}
