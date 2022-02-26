package com.simin.siru.dto;

import java.time.LocalDateTime;

import com.simin.siru.entity.Empathy;
import com.simin.siru.entity.Member;
import com.simin.siru.entity.Post;

import lombok.Getter;

@Getter
public class EmpathyRegistRequest {
    private Long postId;
    private Long memberId;

    public Empathy toEntity() {
        return Empathy.builder()
            .registDt(LocalDateTime.now())
            .post(new Post(postId))
            .member(new Member(memberId))
            .build();
    }
}
