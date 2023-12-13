package com.imsouane.aftas.service.impl;

import com.imsouane.aftas.domain.entities.Member;
import com.imsouane.aftas.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl {
    public Member save(Member entity) {
        return memberRepository.save(entity);
    }

    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }

    public Optional<Member> findByNum(Integer num) {
        return memberRepository.findByNum(num);
    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

    public Page<Member> findAll(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }

    private final MemberRepository memberRepository;
}
