package com.example.article.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenResponse {
    private String accessToken;

    public static TokenResponse of(String accessToken) {
        return new TokenResponse(accessToken);
    }
}
