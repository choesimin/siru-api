package com.simin.siru.dto;

import java.time.LocalDateTime;

import com.simin.siru.entity.Post;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostResponse {
    private Long id;
    private String category;
    private String title;
    private String content;
    private MemberResponse writer;
    private LocalDateTime registDt;

    static public PostResponse entityToDto(Post post) {
        return PostResponse.builder()
            .id(post.getId())
            .category(post.getCategory())
            .title(post.getTitle())
            .content(post.getContent())
            .writer(MemberResponse.entityToDto(post.getMember()))
            .registDt(post.getRegistDt())
            .build();
    }
}
