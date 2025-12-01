package com.example.article.presentation.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class MemberSignupReqDto {
    @NotBlank
    private String name;
    @Email
    private String email;
    @NotBlank
    private String password;
}
