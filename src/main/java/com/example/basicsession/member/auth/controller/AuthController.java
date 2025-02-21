package com.example.basicsession.member.auth.controller;

import com.example.basicsession.member.auth.dto.AuthLoginRequestDto;
import com.example.basicsession.member.auth.dto.AuthLoginResponseDto;
import com.example.basicsession.member.auth.dto.AuthSignUpRequestDto;
import com.example.basicsession.member.auth.service.AuthService;
import com.example.basicsession.member.common.consts.Const;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public void signup(@RequestBody AuthSignUpRequestDto dto) {
        authService.signup(dto);
    }

    @PostMapping("/login")
    public void login(@RequestBody AuthLoginRequestDto dto, HttpServletRequest request) {
        AuthLoginResponseDto result = authService.login(dto);

        HttpSession session = request.getSession(); // 신규 세션 생성, JSESSIONID 쿠키 발급
        session.setAttribute(Const.LOGIN_USER, result.getMemberId()); // 서버 메모리에 세션 저장
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}
