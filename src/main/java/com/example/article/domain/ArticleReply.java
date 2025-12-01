package com.example.article.domain;

import com.example.article.global.exception.AccessDeniedException;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "article_reply")
public class ArticleReply{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    private ArticleReply(String content, Member member, Article article) {
        this.content = content;
        this.member = member;
        this.article = article;
        article.getArticleReplies().add(this);
        member.getArticleReplies().add(this);
    }

    public void validateOwner(String email) {
        if (!member.getEmail().equals(email)) {
            throw new AccessDeniedException("본인이 작성한 댓글만 삭제할 수 있습니다.");
        }
    }

    public static ArticleReply create(String content, Member member, Article article) {
        return new ArticleReply(content, member, article);
    }
}
