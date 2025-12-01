package com.example.article.infrastructure;

import com.example.article.domain.ArticleReply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleReplyJpaRepository extends JpaRepository<ArticleReply, Long> {
    List<ArticleReply> findByArticleIdOrderByCreatedAtAsc(Long articleId);
}
