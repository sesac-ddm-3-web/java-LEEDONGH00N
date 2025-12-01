package com.example.article.presentation;


import com.example.article.application.MemberService;
import com.example.article.global.jwt.JwtProvider;
import com.example.article.presentation.dto.request.MemberLoginReqDto;
import com.example.article.presentation.dto.request.MemberSignupReqDto;
import com.example.article.presentation.dto.response.TokenResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@Valid @RequestBody MemberSignupReqDto request) {
        memberService.signUpMember(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@Valid @RequestBody MemberLoginReqDto request){
        return ResponseEntity.status(HttpStatus.OK).body(memberService.loginMember(request));
    }
}
