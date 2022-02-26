package com.simin.siru.dto;

import java.time.LocalDateTime;

import com.simin.siru.entity.Comment;
import com.simin.siru.entity.Member;
import com.simin.siru.entity.Post;

import lombok.Getter;

@Getter
public class CommentRegistRequest {
    private Long postId;
    private Long memberId;
    private String content;

    public Comment toEntity() {
        LocalDateTime now = LocalDateTime.now();
        return Comment.builder()
            .content(content)
            .registDt(now)
            .updateDt(now)
            .member(new Member(memberId))
            .post(new Post(postId))
            .build();
    }
}
