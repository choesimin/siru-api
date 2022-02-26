package com.simin.siru.dto;

import java.time.LocalDateTime;

import com.simin.siru.entity.Member;
import com.simin.siru.util.PasswordGenerator;

import lombok.Getter;

@Getter
public class MemberRegistRequest {
    private String email;
    private String password;
    private String name;

    public Member toEntity() {
        LocalDateTime now = LocalDateTime.now();
        return Member.builder()
            .email(email)
            .password(PasswordGenerator.getSecureData(password))
            .name(name)
            .registDt(now)
            .updateDt(now)
            .build();
    }
}
