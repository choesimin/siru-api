package com.simin.siru.dto;

import java.time.LocalDateTime;

import com.simin.siru.entity.Comment;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentResponse {
    private Long id;
    private String content;
    private Long memberId;
    private MemberResponse writer;
    private LocalDateTime registDt;

    static public CommentResponse entityToDto(Comment comment) {
        return CommentResponse.builder()
            .id(comment.getId())
            .content(comment.getContent())
            .writer(MemberResponse.entityToDto(comment.getMember()))
            .memberId(comment.getMember().getId())
            .registDt(comment.getRegistDt())
            .build();
    }
}
