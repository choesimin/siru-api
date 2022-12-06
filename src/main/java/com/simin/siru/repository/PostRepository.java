package com.simin.siru.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.simin.siru.entity.Post;

public interface PostRepository extends JpaRepository <Post, Long> {
    List<Post> findAllByCategoryOrderByRegistDtDesc(String category, Pageable pageable);
    Long countByCategory(String category);
    List<Post> findByIdInOrderByRegistDtDesc(List<Long> ids);
}