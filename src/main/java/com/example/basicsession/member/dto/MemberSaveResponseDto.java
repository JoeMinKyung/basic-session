package com.example.basicsession.member.dto;

public class MemberSaveResponseDto {

    private final Long id;
    private final String email;

    public MemberSaveResponseDto(Long id, String email) {
        this.id = id;
        this.email = email;
    }
}
