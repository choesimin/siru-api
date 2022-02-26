package com.simin.siru.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    @Column(length = 50)
    private String email;
    @Column(length = 100)
    private String password;
    @Column(length = 10)
    private String name;
    private LocalDateTime registDt;
    private LocalDateTime updateDt;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Post> posts;
    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Comment> comments;
    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE)
    private List<Empathy> empathies;

    public Member (Long id) {
        this.id = id;
    }

    @Builder
    public Member (
        Long id,
        String email,
        String password,
        String name,
        LocalDateTime registDt,
        LocalDateTime updateDt
    ) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.registDt = registDt;
        this.updateDt = updateDt;
    }
}
