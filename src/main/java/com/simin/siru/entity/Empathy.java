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
public class Empathy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empathy_id")
    private Long id;
    private LocalDateTime registDt;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    public Empathy (
        Long id,
        LocalDateTime registDt,
        Member member,
        Post post
    ) {
        this.id = id;
        this.registDt = registDt;
        this.member = member;
        this.post = post;
    }
}
