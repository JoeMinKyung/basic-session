package com.example.basicsession.member.auth.service;

import com.example.basicsession.member.auth.dto.AuthSignUpRequestDto;
import com.example.basicsession.member.dto.MemberSaveResponseDto;
import com.example.basicsession.member.entity.Member;
import com.example.basicsession.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;

    @Transactional
    public void signup(AuthSignUpRequestDto dto) {
        Member member = new Member(dto.getEmail());
        memberRepository.save(member);
    }
}
