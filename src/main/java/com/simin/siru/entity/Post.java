package com.simin.siru.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;
    @Column(length = 10)
    private String category;
    @Column(length = 50)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime registDt;
    private LocalDateTime updateDt;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Comment> comments;
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Empathy> empathies;


    public Post (Long id) {
        this.id = id;
    }

    @Builder
    public Post (
        Long id,
        String category,
        String title,
        String content,
        LocalDateTime registDt,
        LocalDateTime updateDt,
        Member member
    ) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.content = content;
        this.registDt = registDt;
        this.updateDt = updateDt;
        this.member = member;
    }
}
