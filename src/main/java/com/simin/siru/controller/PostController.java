package com.simin.siru.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simin.siru.dto.CommentResponse;
import com.simin.siru.dto.PostDeleteRequest;
import com.simin.siru.dto.PostRegistRequest;
import com.simin.siru.dto.PostResponse;
import com.simin.siru.dto.PostUpdateRequest;
import com.simin.siru.entity.Post;
import com.simin.siru.service.CommentService;
import com.simin.siru.service.EmpathyService;
import com.simin.siru.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;
    private final CommentService commentService;
    private final EmpathyService empathyService;

    @PostMapping()
    public void regist(@RequestBody PostRegistRequest request) {
        postService.save(request.toEntity());
    }

    @GetMapping("/category/{category}")
    public PostResponse[] list(@PathVariable("category") String category, Pageable pageable) {
        return postService.listByCategory(category, pageable).stream().map(PostResponse::entityToDto).toArray(PostResponse[]::new);
    }

    @GetMapping("/category/{category}/count")
    public Long count(@PathVariable("category") String category) {
        return postService.countByCategory(category);
    }

    @GetMapping("/category/{category}/top/{size}")
    public PostResponse[] topList(@PathVariable("category") String category, @PathVariable("size") Long size) {
        return postService.listTopByCategory(category, size).stream().map(PostResponse::entityToDto).toArray(PostResponse[]::new);
    }

    @GetMapping("/{id}")
    public PostResponse detail(@PathVariable("id") Long id) {
        return PostResponse.entityToDto(postService.detail(id));
    }

    @GetMapping("/{id}/comment")
    public CommentResponse[] list(@PathVariable("id") Long id) {
        return commentService.list(id).stream().map(CommentResponse::entityToDto).toArray(CommentResponse[]::new);
    }

    @GetMapping("/{id}/empathy/count")
    public Long count(@PathVariable("id") Long id) {
        return empathyService.count(id);
    }

    @GetMapping("/{id}/empathy/{memberId}/count")
    public Long count(@PathVariable("id") Long id, @PathVariable("memberId") Long memberId) {
        return empathyService.count(id, memberId);
    }

    @PutMapping()
    public void update(@RequestBody PostUpdateRequest request) {
        Post origin = postService.detail(request.getId());
        postService.save(request.toEntity(origin));
    }

    @DeleteMapping()
    public void delete(@RequestBody PostDeleteRequest request) {
        postService.delete(request.getId());
    }
}