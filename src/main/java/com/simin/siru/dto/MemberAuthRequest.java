package com.simin.siru.dto;

import com.simin.siru.entity.Member;
import com.simin.siru.util.PasswordGenerator;

import lombok.Getter;

@Getter
public class MemberAuthRequest {
    private String email;
    private String password;

    public Member toEntity() {
        return Member.builder()
            .email(email)
            .password(PasswordGenerator.getSecureData(password))
            .build();
    }
}
