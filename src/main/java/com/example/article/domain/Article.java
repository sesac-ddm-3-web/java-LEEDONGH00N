package com.example.article.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "article")
public class Article{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Long views = 0L;
    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<ArticleReply> articleReplies = new ArrayList<>();

    public Article(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.member = member;
        member.getArticles().add(this);
    }

    public void addView(){
        this.views++;
    }

    public static Article create(String title, String content, Member member) {
        return new Article(title, content, member);
    }
}
