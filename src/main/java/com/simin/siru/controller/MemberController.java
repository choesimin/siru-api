package com.simin.siru.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simin.siru.dto.MemberAuthRequest;
import com.simin.siru.dto.MemberAuthResponse;
import com.simin.siru.dto.MemberDeleteRequest;
import com.simin.siru.dto.MemberRegistRequest;
import com.simin.siru.dto.MemberResponse;
import com.simin.siru.dto.MemberUpdateRequest;
import com.simin.siru.entity.Member;
import com.simin.siru.service.MemberService;
import com.simin.siru.util.JwtManager;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final JwtManager jwtManager;
    private final MemberService memberService;

    @PostMapping()
    public void regist(@RequestBody MemberRegistRequest request) {
        memberService.save(request.toEntity());
    }

    @GetMapping("/{id}")
    public MemberResponse detail(@PathVariable("id") Long id) {
        return MemberResponse.entityToDto(memberService.detail(id));
    }

    @PostMapping("/auth")
    public MemberAuthResponse auth(@RequestBody MemberAuthRequest request) {
        Member member = memberService.getByEmailAndPassword(request.toEntity());
        String token = jwtManager.generateJwtToken(member.getId());

        return new MemberAuthResponse(member.getId(), token);
    }

    @PutMapping()
    public void update(@RequestBody MemberUpdateRequest request) {
        Member origin = memberService.detail(request.getId());
        memberService.save(request.toEntity(origin));
    }

    @DeleteMapping()
    public void delete(@RequestBody MemberDeleteRequest request) {
        memberService.delete(request.getId());
    }
}