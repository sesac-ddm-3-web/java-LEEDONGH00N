package com.example.article.application;


import com.example.article.domain.Member;
import com.example.article.global.exception.AuthException;
import com.example.article.infrastructure.MemberJpaRepository;
import com.example.article.presentation.dto.request.MemberLoginReqDto;
import com.example.article.presentation.dto.request.MemberSignupReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberJpaRepository memberJpaRepository;

    @Transactional
    public void signUpMember(MemberSignupReqDto request){
        Member member = Member.create(request.getName(), request.getEmail(), request.getPassword());
        memberJpaRepository.save(member);
    }

    @Transactional
    public String loginMember(MemberLoginReqDto request){
        Member member = loadMemberOrThrow(request);
        return member.getEmail();
    }

    private Member loadMemberOrThrow(MemberLoginReqDto request) {
        return memberJpaRepository
                .findByEmailAndPassword(request.getEmail(), request.getPassword())
                .orElseThrow(() -> new AuthException("로그인에 실패함"));
    }
}
