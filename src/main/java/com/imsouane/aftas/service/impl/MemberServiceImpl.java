package com.imsouane.aftas.service.impl;

import com.imsouane.aftas.domain.entities.Member;
import com.imsouane.aftas.exception.ResourceNotFoundException;
import com.imsouane.aftas.repository.MemberRepository;
import com.imsouane.aftas.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public Member save(Member entity) {
        return memberRepository.save(entity);
    }

    @Override
    public Member findById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + id));
    }

    @Override
    public Member findByNum(Integer num) {
        return memberRepository.findByNum(num).orElseThrow(() -> new ResourceNotFoundException("Member not found with num: " + num));
    }

    @Override
    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public List<Member> findAll(Pageable pageable) {
        return memberRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Member> search(String query) {
        return memberRepository.findByMembershipNumberOrNameOrFamilyName(query);
    }
}
