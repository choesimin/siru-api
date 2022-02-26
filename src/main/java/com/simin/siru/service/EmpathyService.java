package com.simin.siru.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.simin.siru.entity.Empathy;
import com.simin.siru.repository.EmpathyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpathyService {
    private final EmpathyRepository empathyRepository;

    public List<Empathy> list(Long postId) {
        return empathyRepository.findAllByPostId(postId);
    }

    public Empathy detail(Long postId, Long memberId) {
        return empathyRepository.findByPostIdAndMemberId(postId, memberId).orElse(new Empathy());
    }

    public Long count(Long postId, Long memberId) {
        return empathyRepository.countByPostIdAndMemberId(postId, memberId);
    }

    public void save(Empathy empathy) {
        if (count(empathy.getPost().getId(), empathy.getMember().getId()) == 0) {
            empathyRepository.save(empathy);
        }
    }

    public void delete(Long postId, Long memberId) {
        empathyRepository.delete(detail(postId, memberId));
    }

    public Long count(Long postId) {
        return empathyRepository.countByPostId(postId);
    }

}
