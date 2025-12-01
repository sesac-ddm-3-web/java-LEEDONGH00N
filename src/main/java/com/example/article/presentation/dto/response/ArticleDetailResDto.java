package com.example.article.presentation.dto.response;

import com.example.article.domain.Article;
import com.example.article.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ArticleDetailResDto {
    private String title;
    private String content;
    private String author;
    private Long view;
    private LocalDateTime createdAt;
    private Boolean mine;

    public static ArticleDetailResDto from(Article article, Member member) {
        return new ArticleDetailResDto(
                article.getTitle(),
                article.getContent(),
                member.getName(),
                article.getViews(),
                article.getCreatedAt(),
                article.isWrittenBy(member)
        );
    }
}
