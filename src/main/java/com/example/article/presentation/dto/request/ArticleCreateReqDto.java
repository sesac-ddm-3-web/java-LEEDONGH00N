package com.example.article.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ArticleCreateReqDto {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
}
