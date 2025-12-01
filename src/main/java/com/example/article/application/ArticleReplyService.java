package com.example.article.application;

import com.example.article.domain.Article;
import com.example.article.domain.ArticleReply;
import com.example.article.domain.Member;
import com.example.article.infrastructure.ArticleJpaRepository;
import com.example.article.infrastructure.ArticleReplyJpaRepository;
import com.example.article.infrastructure.MemberJpaRepository;
import com.example.article.presentation.dto.response.ArticleReplyResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class ArticleReplyService {

    private final ArticleJpaRepository articleRepository;
    private final MemberJpaRepository memberRepository;
    private final ArticleReplyJpaRepository articleReplyRepository;

    public void createReply(Long articleId, String loginMemberEmail, String content) {
        Member member = loadMemberOrThrow(loginMemberEmail);
        Article article = loadArticleOrThrow(articleId);
        ArticleReply reply = ArticleReply.create(content, member, article);
        articleReplyRepository.save(reply);
    }

    @Transactional(readOnly = true)
    public List<ArticleReplyResDto> getReplies(Long articleId, String loginMemberEmail) {
        loadMemberOrThrow(loginMemberEmail);
        return articleReplyRepository.findByArticleIdOrderByCreatedAtAsc(articleId)
                .stream()
                .map(ArticleReplyResDto::from)
                .toList();
    }

    public void deleteReply(Long replyId, String loginMemberEmail) {
        ArticleReply reply = loadArticleReplyOrThrow(replyId);
        reply.validateOwner(loginMemberEmail);
        articleReplyRepository.delete(reply);
    }

    private ArticleReply loadArticleReplyOrThrow(Long replyId) {
        return articleReplyRepository.findById(replyId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));
    }

    private Member loadMemberOrThrow(String loginMemberEmail) {
        return memberRepository.findByEmail(loginMemberEmail)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
    }

    private Article loadArticleOrThrow(Long articleId) {
        return articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
    }
}