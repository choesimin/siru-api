package com.simin.siru.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.simin.siru.entity.Comment;
import com.simin.siru.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public List<Comment> list(Long postId) {
        return commentRepository.findAllByPostId(postId);
    }

    public Comment detail(Long id) {
        return commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public Comment detailByPostIdAndMemberId(Long postId, Long memberId) {
        return commentRepository.findByPostIdAndMemberId(postId, memberId).orElseThrow(() -> new IllegalArgumentException());
    }

    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

}
