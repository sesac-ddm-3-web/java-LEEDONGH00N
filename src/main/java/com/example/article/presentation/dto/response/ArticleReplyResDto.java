package com.example.article.presentation.dto.response;

import com.example.article.domain.ArticleReply;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ArticleReplyResDto {
    private Long id;
    private String content;
    private String writerName;
    private LocalDateTime createdAt;

    public static ArticleReplyResDto from(ArticleReply reply) {
        return new ArticleReplyResDto(
                reply.getId(),
                reply.getContent(),
                reply.getMember().getName(),
                reply.getCreatedAt()
        );
    }
}
