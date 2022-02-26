package com.simin.siru.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.simin.siru.entity.Empathy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpathyRepository extends JpaRepository <Empathy, Long> {
    List<Empathy> findAllByPostId(Long postId);
    Optional<Empathy> findByPostIdAndMemberId(Long postId, Long memberId);
    Long countByPostIdAndMemberId(Long postId, Long memberId);
    Long countByPostId(Long postId);
    List<Empathy> findAllByRegistDtBetween(LocalDateTime start, LocalDateTime end);
}
