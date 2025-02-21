package com.example.basicsession.member.controller;

import com.example.basicsession.member.dto.MemberResponseDto;
import com.example.basicsession.member.dto.MemberSaveRequestDto;
import com.example.basicsession.member.dto.MemberSaveResponseDto;
import com.example.basicsession.member.dto.MemberUpdateRequestDto;
import com.example.basicsession.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members")
    public ResponseEntity<List<MemberResponseDto>> getAll() {
        return ResponseEntity.ok(memberService.findAll());
    }

    @GetMapping("/members/{memberId}")
    public ResponseEntity<MemberResponseDto> getOne(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.findById(memberId));
    }

    @PutMapping("/members/{memberId}")
    public void update(@PathVariable Long memberId, @RequestBody MemberUpdateRequestDto dto) {
        memberService.update(memberId, dto);
    }

    @DeleteMapping("/members/{memberId}")
    public void delete(@PathVariable Long memberId) {
        memberService.deleteById(memberId);
    }
}
