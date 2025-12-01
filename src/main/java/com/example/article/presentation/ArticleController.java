package com.example.article.presentation;

import com.example.article.application.ArticleService;
import com.example.article.global.annotation.LoginMember;
import com.example.article.presentation.dto.request.ArticleCreateReqDto;
import com.example.article.presentation.dto.response.ArticleBriefResDto;
import com.example.article.presentation.dto.response.ArticleDetailResDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity<Void> createArticle(@Valid @RequestBody ArticleCreateReqDto request,
                                              @LoginMember String loginMemberEmail){
        articleService.createArticle(request,loginMemberEmail);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ArticleBriefResDto>> getAllArticles(@LoginMember String loginMemberEmail){
        return ResponseEntity.ok(articleService.getAllArticles(loginMemberEmail));
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<ArticleDetailResDto> getArticleById(@PathVariable Long articleId,
                                                              @LoginMember String loginMemberEmail){
        return ResponseEntity.status(HttpStatus.OK).body(articleService.getArticleDetail(loginMemberEmail, articleId));
    }

    @DeleteMapping("/{articleId}")
    public ResponseEntity<Void> deleteArticleById(@PathVariable Long articleId,
                                                  @LoginMember String loginMemberEmail){
        articleService.deleteArticle(loginMemberEmail, articleId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
