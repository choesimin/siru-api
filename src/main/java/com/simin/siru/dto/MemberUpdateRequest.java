package com.simin.siru.dto;

import java.time.LocalDateTime;

import com.simin.siru.entity.Member;
import com.simin.siru.util.PasswordGenerator;

import lombok.Getter;

@Getter
public class MemberUpdateRequest {
    private Long id;
    private String email;
    private String password;
    private String name;

    public Member toEntity(Member origin) {
        return Member.builder()
            .id(id)
            .email(email)
            .password(PasswordGenerator.getSecureData(password))
            .name(name)
            .registDt(origin.getRegistDt())
            .updateDt(LocalDateTime.now())
            .build();
    }
}
