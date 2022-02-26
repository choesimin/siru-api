package com.simin.siru.repository;

import com.simin.siru.entity.Member;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository <Member, Long> {
    Long countByEmail(String email);
    Long countByName(String name);
    Member findByEmailAndPassword(String email, String password);
}
