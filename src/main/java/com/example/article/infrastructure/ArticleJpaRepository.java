package com.example.article.infrastructure;

import com.example.article.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ArticleJpaRepository extends JpaRepository<Article, Long> {
    List<Article> findAll();
}
