package com.simin.siru.dto;

import java.time.LocalDateTime;

import com.simin.siru.entity.Member;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberResponse {
    private Long id;
    private String email;
    private String name;
    private LocalDateTime registDt;

    static public MemberResponse entityToDto(Member member) {
        return MemberResponse.builder()
            .id(member.getId())
            .email(member.getEmail())
            .name(member.getName())
            .registDt(member.getRegistDt())
            .build();
    }
}
