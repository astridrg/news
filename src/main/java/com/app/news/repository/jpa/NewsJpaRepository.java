package com.app.news.repository.jpa;

import com.app.news.repository.model.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface NewsJpaRepository extends JpaRepository<NewsEntity, UUID> {

    Optional<NewsEntity> findByTitle(String title);
}
