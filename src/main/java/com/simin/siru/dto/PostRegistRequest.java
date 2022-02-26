package com.simin.siru.dto;

import java.time.LocalDateTime;

import com.simin.siru.entity.Member;
import com.simin.siru.entity.Post;

import lombok.Getter;

@Getter
public class PostRegistRequest {
    private Long memberId;
    private String category;
    private String title;
    private String content;

    public Post toEntity() {
        LocalDateTime now = LocalDateTime.now();
        return Post.builder()
            .category(category)
            .title(title)
            .content(content)
            .registDt(now)
            .updateDt(now)
            .member(new Member(memberId))
            .build();
    }
}
