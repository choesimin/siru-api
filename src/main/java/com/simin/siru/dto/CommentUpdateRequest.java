package com.simin.siru.dto;

import java.time.LocalDateTime;

import com.simin.siru.entity.Comment;
import com.simin.siru.entity.Member;
import com.simin.siru.entity.Post;

import lombok.Getter;

@Getter
public class CommentUpdateRequest {
    private Long id;
    private String content;

    public Comment toEntity(Comment origin) {
        return Comment.builder()
            .id(origin.getId())
            .content(content)
            .registDt(origin.getRegistDt())
            .updateDt(LocalDateTime.now())
            .member(new Member(origin.getMember().getId()))
            .post(new Post(origin.getPost().getId()))
            .build();
    }
}
