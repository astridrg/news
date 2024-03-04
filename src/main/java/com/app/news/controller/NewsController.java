package com.app.news.controller;


import com.app.news.controller.mapper.NewToNewsResponseMapper;
import com.app.news.controller.mapper.NewsRequestUpdateToNewsMapper;
import com.app.news.controller.mapper.NewsToNewsRequestMapper;
import com.app.news.controller.model.request.NewsRequestUpdate;
import com.app.news.controller.model.response.NewsResponse;
import com.app.news.controller.model.request.NewsRequest;
import com.app.news.domain.model.News;
import com.app.news.domain.port.in.NewsIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/news")
public class NewsController {

    private NewsIn newsIn;
    private NewsToNewsRequestMapper newsToNewsRequestMapper;
    private NewToNewsResponseMapper newToNewsResponseMapper;
    private NewsRequestUpdateToNewsMapper newsRequestUpdateToNewsMapper;

    public NewsController(NewsIn newsIn, NewsToNewsRequestMapper newsToNewsRequestMapper,
                          NewToNewsResponseMapper newToNewsResponseMapper, NewsRequestUpdateToNewsMapper newsRequestUpdateToNewsMapper) {
        this.newsIn = newsIn;
        this.newsToNewsRequestMapper = newsToNewsRequestMapper;
        this.newToNewsResponseMapper = newToNewsResponseMapper;
        this.newsRequestUpdateToNewsMapper = newsRequestUpdateToNewsMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<NewsResponse> createNews(@RequestBody @Valid NewsRequest newsRequest) {
        News news = newsToNewsRequestMapper.newsRequestToNews(newsRequest);
        NewsResponse response = newToNewsResponseMapper.newsToNewsResponse(newsIn.saveNews(news));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity <NewsResponse> getNewsById(@PathVariable UUID id) {
        NewsResponse newsResponse = newToNewsResponseMapper.newsToNewsResponse(newsIn.getNewsById(id));
        return new ResponseEntity<>(newsResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<NewsResponse>> getListNews() {
        List<NewsResponse> newsResponseList = newToNewsResponseMapper.newsResponseList(newsIn.getListNews()) ;
        return new ResponseEntity<>(newsResponseList, HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity <NewsResponse> getNewsByTitle(@PathVariable String title) {
        NewsResponse newsResponse = newToNewsResponseMapper.newsToNewsResponse(newsIn.getNewsByTitle(title));
        return new ResponseEntity<>(newsResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteNewsById(@PathVariable UUID id) {
       newsIn.deleteNewsById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsResponse> updateNews(@PathVariable UUID id,
                                                   @Valid @RequestBody NewsRequestUpdate newsRequestUpdate) {
        News news = newsRequestUpdateToNewsMapper.newsRequestUpdateToNews(newsRequestUpdate);
        NewsResponse newsResponse = newToNewsResponseMapper.newsToNewsResponse(newsIn.updateNews(id, news));
        return new ResponseEntity<>(newsResponse, HttpStatus.OK);
    }

}

