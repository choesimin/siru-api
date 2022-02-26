package com.simin.siru.service;

import org.springframework.stereotype.Service;

import com.simin.siru.entity.Member;
import com.simin.siru.exception.EmailDuplicatedException;
import com.simin.siru.exception.NameDuplicatedException;
import com.simin.siru.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member detail(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public void save(Member member) {
        if (memberRepository.countByEmail(member.getEmail()) > 0) {
            throw new EmailDuplicatedException();
        } else if (memberRepository.countByName(member.getName()) > 0) {
            throw new NameDuplicatedException();
        }

        memberRepository.save(member);
    }

    public void delete(Long id) {
        memberRepository.deleteById(id);
    }

    public Member getByEmailAndPassword(Member memberParam) {
        Member memberResult = memberRepository.findByEmailAndPassword(memberParam.getEmail(), memberParam.getPassword());
        if (memberResult == null) {
            throw new RuntimeException("");
        }
        return memberResult;
    }

}
