package com.simin.siru.repository;

import java.util.List;
import java.util.Optional;

import com.simin.siru.entity.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository <Comment, Long> {
    List<Comment> findAllByPostId(Long postId);
    Optional<Comment> findByPostIdAndMemberId(Long postId, Long memberId);
}
