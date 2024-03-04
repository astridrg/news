package com.app.news.domain.port.in;


import com.app.news.domain.model.News;

import java.util.List;
import java.util.UUID;

public interface NewsIn {

    public News saveNews(News news);
    public List<News> getListNews();
    public News getNewsByTitle(String title);
    public void deleteNewsById(UUID id);
    public News updateNews(UUID id, News news);
    public News getNewsById(UUID id);


}
