package com.example.article.application;

import com.example.article.domain.Article;
import com.example.article.domain.Member;
import com.example.article.global.exception.AuthException;
import com.example.article.global.exception.EntityNotFoundException;
import com.example.article.infrastructure.ArticleJpaRepository;
import com.example.article.infrastructure.MemberJpaRepository;
import com.example.article.presentation.dto.request.ArticleCreateReqDto;
import com.example.article.presentation.dto.response.ArticleBriefResDto;
import com.example.article.presentation.dto.response.ArticleDetailResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleService {

    private final ArticleJpaRepository articleJpaRepository;
    private final MemberJpaRepository memberJpaRepository;

    @Transactional
    public void createArticle(ArticleCreateReqDto request, String memberEmail){
        Member member = loadMemberOrThrow(memberEmail);
        Article article = Article.create(request.getTitle(), request.getContent(), member);
        articleJpaRepository.save(article);
    }

    public List<ArticleBriefResDto> getAllArticles(String memberEmail){
        Member member = loadMemberOrThrow(memberEmail);
        List<Article> articles = articleJpaRepository.findAll();
        return ArticleBriefResDto.fromEntities(articles, member);
    }

    @Transactional
    public ArticleDetailResDto getArticleDetail(String memberEmail, Long articleId){
        Member member = loadMemberOrThrow(memberEmail);
        Article article = loadArticleOrThrow(articleId);
        article.addView();
        return ArticleDetailResDto.from(article, member);
    }

    private Article loadArticleOrThrow(Long articleId) {
        return articleJpaRepository.findById(articleId)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 게시글"));
    }

    private Member loadMemberOrThrow(String memberEmail) {
        return memberJpaRepository.findByEmail(memberEmail)
                .orElseThrow(() -> new AuthException("존재하지 않는 회원"));
    }
}
