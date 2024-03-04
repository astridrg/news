package com.app.news.domain.port.out;

import com.app.news.domain.model.News;

import java.util.List;
import java.util.UUID;

public interface NewsOut {

    public News saveNews(News news) ;
    public List<News> getListNews();
    public News getNewsByTitle(String title);
    public void deleteNewsById(UUID id);
    public News updateNews(UUID id, News news);
    public News getNewsById(UUID id);


}
