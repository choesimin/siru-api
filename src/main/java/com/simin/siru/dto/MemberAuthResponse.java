package com.simin.siru.dto;

import lombok.Getter;

@Getter
public class MemberAuthResponse {
    private Long id;
    private String token;

    public MemberAuthResponse(Long id, String token) {
        this.id = id;
        this.token = token;
    }
}
