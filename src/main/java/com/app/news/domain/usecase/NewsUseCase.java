package com.app.news.domain.usecase;

import com.app.news.domain.model.News;
import com.app.news.domain.port.in.NewsIn;
import com.app.news.domain.port.out.NewsOut;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NewsUseCase implements NewsIn {

    private NewsOut newsOut;

    public NewsUseCase(NewsOut newsOut) {
        this.newsOut = newsOut;
    }

    public News saveNews(News news) {
        News newsSave = newsOut.saveNews(news);
        return newsSave;
    }

    public List<News> getListNews() {
        List<News> newsList = newsOut.getListNews();
        return newsList;
    }

    public News getNewsByTitle(String title) {
        News news = newsOut.getNewsByTitle(title);
        return news;
    }

    public void deleteNewsById(UUID id) {
        newsOut.deleteNewsById(id);
    }

    public News updateNews(UUID id, News news) {
        News newsUpdate = newsOut.updateNews(id,news );
        return newsUpdate;
    }

    @Override
    public News getNewsById(UUID id) {
        News news = newsOut.getNewsById(id);
        return news;
    }
}
