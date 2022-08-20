package com.simin.siru.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.simin.siru.entity.Empathy;
import com.simin.siru.entity.Post;
import com.simin.siru.repository.EmpathyRepository;
import com.simin.siru.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final EmpathyRepository empathyRepository;

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
        return postRepository.findAllByCategoryOrderByRegistDtDesc(category);
    }

    public Long countByCategory(String category) {
        return postRepository.countByCategory(category);
    }

    public List<Post> listTopByCategory(String category, Long size) {
        return postRepository.findByIdInOrderByRegistDtDesc(topIds(category, size));
    }

    private List<Long> topIds(String category, Long size) {
        LocalDateTime now = LocalDateTime.now();

        return empathyRepository.findAllByRegistDtBetween(now.minusDays(100), now).stream()
            .map(Empathy::getPost)
            .filter(post -> post.getCategory().equals(category))
            .collect(Collectors.groupingBy(Post::getId, Collectors.counting()))
            .entrySet().stream()
            .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
            .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
            .map(Entry::getKey)
            .limit(size).collect(Collectors.toList());
    }
}
