package repository;

import com.app.news.domain.exceptions.NotFoundedException;
import com.app.news.domain.model.News;
import com.app.news.repository.NewsInDataBase;
import com.app.news.repository.jpa.NewsJpaRepository;
import com.app.news.repository.mapper.NewsEntityToNewsMapper;
import com.app.news.repository.mapper.NewsToNewsEntityMapper;
import com.app.news.repository.model.NewsEntity;
import mocks.NewsEntityMock;
import mocks.NewsMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class NewsInDataBaseTest {

    @Mock
    private NewsJpaRepository newsJpaRepository;
    @Mock
    private NewsToNewsEntityMapper newsToNewsEntityMapper;
    @Mock
    private NewsEntityToNewsMapper newsEntityToNewsMapper;

    private NewsInDataBase newsInDataBase;

    @BeforeEach
    public void init(){
        newsInDataBase = new NewsInDataBase(newsJpaRepository, newsToNewsEntityMapper, newsEntityToNewsMapper );
    }

    @Test
    public void saveUserInDataBaseTest(){
        News newsMock = NewsMock.news();
        NewsEntity newsEntity = NewsEntityMock.newsEntity();

        Mockito.when(newsToNewsEntityMapper.newsToNewsEntity(newsMock)).thenReturn(newsEntity);
        Mockito.when(newsJpaRepository.save(newsEntity)).thenReturn(newsEntity);
        Mockito.when(newsEntityToNewsMapper.newsEntityToNews(newsEntity)).thenReturn(newsMock);

        News news = newsInDataBase.saveNews(newsMock);

        Mockito.verify(newsJpaRepository, Mockito.times(1)).save(newsEntity);
        assertThat(news)
                .usingRecursiveComparison()
                .isEqualTo(newsMock);
    }

    @Test
    public void getListNewsInDataBaseTest(){
        List<News> newsList = NewsMock.newsList();
        List<NewsEntity> newsEntityList = NewsEntityMock.newsEntityList();

        Mockito.when(newsJpaRepository.findAll()).thenReturn(newsEntityList);
        Mockito.when(newsEntityToNewsMapper.listNewsEntityToListNews(newsEntityList)).thenReturn(newsList);

        List<News> news = newsInDataBase.getListNews();

        Mockito.verify(newsJpaRepository, Mockito.times(1)).findAll();
        assertThat(news)
                .usingRecursiveComparison()
                .isEqualTo(newsList);
    }

    @Test
    public void deleteNewsByIdInDataBaseTest() {
        NewsEntity newsEntity = NewsEntityMock.newsEntity();

        Mockito.when(newsJpaRepository.findById(newsEntity.getId())).thenReturn(Optional.of(newsEntity));
        Mockito.doNothing().when(newsJpaRepository).deleteById(newsEntity.getId());

        newsInDataBase.deleteNewsById(newsEntity.getId());

        Mockito.verify(newsJpaRepository, Mockito.times(1)).deleteById(newsEntity.getId());
    }

    @Test
    public void deleteNewsByIdInDataBaseWhenDontFindIdNewsTest() {
        NewsEntity newsEntity = NewsEntityMock.newsEntity();

        Mockito.when(newsJpaRepository.findById(newsEntity.getId())).thenReturn(Optional.empty());

        assertThrows(NotFoundedException.class,
                ()-> {
                    newsInDataBase.deleteNewsById(newsEntity.getId());
                });

        Mockito.verify(newsJpaRepository, Mockito.times(0)).deleteById(newsEntity.getId());
    }

    @Test
    public void getNewsByIdInDataBaseTest() {
        NewsEntity newsEntity = NewsEntityMock.newsEntity();
        News newsMock = NewsMock.news();

        Mockito.when(newsJpaRepository.findById(newsEntity.getId())).thenReturn(Optional.of(newsEntity));
        Mockito.when(newsEntityToNewsMapper.newsEntityToNews(newsEntity)).thenReturn(newsMock);

        newsInDataBase.getNewsById(newsMock.getId());

        Mockito.verify(newsJpaRepository, Mockito.times(1)).findById(newsEntity.getId());
    }

    @Test
    public void getNewsByIdInDataBaseWhenDontFindIdNewsTest() {
        NewsEntity newsEntity = NewsEntityMock.newsEntity();
        News newsMock = NewsMock.news();

        Mockito.when(newsJpaRepository.findById(newsEntity.getId())).thenReturn(Optional.empty());

        assertThrows(NotFoundedException.class,
                ()-> {
                    newsInDataBase.getNewsById(newsEntity.getId());
                });

        Mockito.verify(newsJpaRepository, Mockito.times(0)).deleteById(newsEntity.getId());
    }

    @Test
    public void getNewsByTitleInDataBaseTest() {
        NewsEntity newsEntity = NewsEntityMock.newsEntity();
        News newsMock = NewsMock.news();

        Mockito.when(newsJpaRepository.findByTitle(newsEntity.getTitle())).thenReturn(Optional.of(newsEntity));
        Mockito.when(newsEntityToNewsMapper.newsEntityToNews(newsEntity)).thenReturn(newsMock);

        newsInDataBase.getNewsByTitle(newsMock.getTitle());

        Mockito.verify(newsJpaRepository, Mockito.times(1)).findByTitle(newsEntity.getTitle());
    }

    @Test
    public void getNewsByTitleInDataBaseWhenDontFindIdNewsTest() {
        NewsEntity newsEntity = NewsEntityMock.newsEntity();
        News newsMock = NewsMock.news();

        Mockito.when(newsJpaRepository.findByTitle(newsEntity.getTitle())).thenReturn(Optional.empty());

        assertThrows(NotFoundedException.class,
                ()-> {
                    newsInDataBase.getNewsByTitle(newsEntity.getTitle());
                });

        Mockito.verify(newsJpaRepository, Mockito.times(0)).deleteById(newsEntity.getId());
    }
}
