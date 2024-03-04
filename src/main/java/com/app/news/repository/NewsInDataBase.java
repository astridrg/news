package com.app.news.repository;

import com.app.news.domain.exceptions.NotFoundedException;
import com.app.news.domain.model.News;
import com.app.news.domain.port.out.NewsOut;
import com.app.news.repository.jpa.NewsJpaRepository;
import com.app.news.repository.mapper.NewsEntityToNewsMapper;
import com.app.news.repository.mapper.NewsToNewsEntityMapper;
import com.app.news.repository.model.NewsEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NewsInDataBase implements NewsOut {

    private NewsJpaRepository newsJpaRepository;
    private NewsToNewsEntityMapper newsToNewsEntityMapper;
    private NewsEntityToNewsMapper newsEntityToNewsMapper;

    public NewsInDataBase(NewsJpaRepository newsJpaRepository, NewsToNewsEntityMapper newsToNewsEntityMapper, NewsEntityToNewsMapper newsEntityToNewsMapper) {
        this.newsJpaRepository = newsJpaRepository;
        this.newsToNewsEntityMapper = newsToNewsEntityMapper;
        this.newsEntityToNewsMapper = newsEntityToNewsMapper;
    }

    public News saveNews(News news) {
        NewsEntity newsEntity = newsToNewsEntityMapper.newsToNewsEntity(news);
        NewsEntity newsIntityInBD = newsJpaRepository.save(newsEntity);
        return newsEntityToNewsMapper.newsEntityToNews(newsIntityInBD);
    }

    public List<News> getListNews() {
        List<NewsEntity> newsEntityList = newsJpaRepository.findAll();
        return newsEntityToNewsMapper.listNewsEntityToListNews(newsEntityList);
    }

    public News getNewsByTitle(String title){
        Optional <NewsEntity> newsEntity = newsJpaRepository.findByTitle(title);
        if (newsEntity.isEmpty()) {
            throw new NotFoundedException("Titulo de noticias no encontrado");
        }
        return newsEntityToNewsMapper.newsEntityToNews(newsEntity.get());
    }

    public void deleteNewsById(UUID id) {
        Optional<NewsEntity> newsEntity = newsJpaRepository.findById(id);
        if (newsEntity.isEmpty()) {
            throw new NotFoundedException("Id de noticias no encontrado");
        }
        newsJpaRepository.deleteById(id);
    }

    public News updateNews(UUID id, News news){
        Optional<NewsEntity> newsUpdate = newsJpaRepository.findById(id);
        if (newsUpdate.isEmpty()) {
            throw new NotFoundedException("Id de noticias no encontrado");
         }
        NewsEntity newsEntity = newsToNewsEntityMapper.newsMerge(news, newsUpdate.get());
        NewsEntity saveInBD = newsJpaRepository.save(newsEntity);
        return newsEntityToNewsMapper.newsEntityToNews(saveInBD);

        }

    public News getNewsById(UUID id) {
        Optional<NewsEntity> newsEntity = newsJpaRepository.findById(id);
        if (newsEntity.isEmpty()) {
            throw new NotFoundedException("Id no encontrado");
        }
        return newsEntityToNewsMapper.newsEntityToNews(newsEntity.get());
    }
}


