package com.simin.siru.repository;

import java.util.List;

import com.simin.siru.entity.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository <Post, Long> {
    List<Post> findAllByCategory(String category);
    Long countByCategory(String category);
}
