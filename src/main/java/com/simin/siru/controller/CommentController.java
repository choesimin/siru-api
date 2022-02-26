package com.simin.siru.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simin.siru.dto.CommentDeleteRequest;
import com.simin.siru.dto.CommentRegistRequest;
import com.simin.siru.dto.CommentUpdateRequest;
import com.simin.siru.entity.Comment;
import com.simin.siru.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping()
    public void regist(@RequestBody CommentRegistRequest request) {
        commentService.save(request.toEntity());
    }

    @PutMapping()
    public void update(@RequestBody CommentUpdateRequest request) {
        Comment origin = commentService.detail(request.getId());
        commentService.save(request.toEntity(origin));
    }

    @DeleteMapping()
    public void delete(@RequestBody CommentDeleteRequest request) {
        commentService.delete(request.getId());
    }
}