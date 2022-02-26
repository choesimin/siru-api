package com.simin.siru.dto;

import java.time.LocalDateTime;

import com.simin.siru.entity.Member;
import com.simin.siru.entity.Post;

import lombok.Getter;

@Getter
public class PostUpdateRequest {
    private Long id;
    private String title;
    private String content;

    public Post toEntity(Post origin) {
        return Post.builder()
            .id(origin.getId())
            .category(origin.getCategory())
            .title(title)
            .content(content)
            .registDt(origin.getRegistDt())
            .updateDt(LocalDateTime.now())
            .member(new Member(origin.getMember().getId()))
            .build();
    }
}
