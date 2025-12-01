package com.example.article.presentation.dto.response;

import com.example.article.domain.Article;
import com.example.article.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class ArticleBriefResDto {
    private Long id;
    private String title;
    private String author;
    private Long view;
    private LocalDateTime createdAt;

    public static ArticleBriefResDto from(Article article, Member member) {
        return new ArticleBriefResDto(article.getId(), article.getTitle(), member.getName(), article.getViews(), article.getCreatedAt());
    }

    public static List<ArticleBriefResDto> fromEntities(List<Article> articles, Member member) {
        return articles.stream()
                .map(article -> ArticleBriefResDto.from(article, member))
                .toList();
    }
}
