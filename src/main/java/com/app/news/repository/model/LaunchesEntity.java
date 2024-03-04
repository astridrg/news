package com.app.news.repository.model;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Table(name="launches")
public class LaunchesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "launch_id")
    private UUID id;

    @Column(name = "provider")
    private String provider;

    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "newsId", referencedColumnName = "id")
    private NewsEntity news;

    public LaunchesEntity(UUID id, String provider, NewsEntity news) {
        this.id = id;
        this.provider = provider;
        this.news = news;
    }

    public LaunchesEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public NewsEntity getNews() {
        return news;
    }

    public void setNews(NewsEntity news) {
        this.news = news;
    }
}
