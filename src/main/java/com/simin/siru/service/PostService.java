package com.simin.siru.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.simin.siru.entity.Post;
import com.simin.siru.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Post detail(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public void save(Post post) {
        postRepository.save(post);
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    public List<Post> listByCategory(String category) {
        return postRepository.findAllByCategory(category);
    }

    public Long countByCategory(String category) {
        return postRepository.countByCategory(category);
    }
}
