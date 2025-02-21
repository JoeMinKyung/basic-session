package com.example.basicsession.member.auth.controller;

import com.example.basicsession.member.auth.dto.AuthSignUpRequestDto;
import com.example.basicsession.member.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public String signup(@RequestBody AuthSignUpRequestDto dto) {
        authService.signup(dto);
    }
}
