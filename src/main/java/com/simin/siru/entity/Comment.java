package com.simin.siru.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;
    @Column(columnDefinition = "TEXT") 
    private String content;
    private LocalDateTime registDt;
    private LocalDateTime updateDt;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    public Comment (
        Long id,
        String content,
        LocalDateTime registDt,
        LocalDateTime updateDt,
        Member member,
        Post post
    ) {
        this.id = id;
        this.content = content;
        this.registDt = registDt;
        this.updateDt = updateDt;
        this.member = member;
        this.post = post;
    }
}
