package com.example.article.presentation;


import com.example.article.application.ArticleReplyService;
import com.example.article.global.annotation.LoginMember;
import com.example.article.presentation.dto.request.ArticleReplyCreateReqDto;
import com.example.article.presentation.dto.response.ArticleReplyResDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles/{articleId}/replies")
public class ArticleReplyController {

    private final ArticleReplyService articleReplyService;

    @PostMapping
    public ResponseEntity<Void> createReply(@PathVariable Long articleId,
                                            @Valid @RequestBody ArticleReplyCreateReqDto request,
                                            @LoginMember String loginMemberEmail) {
        articleReplyService.createReply(articleId, loginMemberEmail, request.getContent());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<ArticleReplyResDto>> getReplies(@PathVariable Long articleId,
                                                               @LoginMember String loginMemberEmail) {
        return ResponseEntity.ok(articleReplyService.getReplies(articleId, loginMemberEmail));
    }

    @DeleteMapping("/{replyId}")
    public ResponseEntity<Void> deleteReply(@PathVariable Long articleId,
                                            @PathVariable Long replyId,
                                            @LoginMember String loginMemberEmail) {

        articleReplyService.deleteReply(replyId, loginMemberEmail);
        return ResponseEntity.noContent().build();
    }
}
