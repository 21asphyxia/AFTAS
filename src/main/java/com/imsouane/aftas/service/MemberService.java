package com.imsouane.aftas.service;

import com.imsouane.aftas.domain.entities.Member;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberService {
    Member save(Member entity);

    Member findById(Long id);

    Member findByNum(Integer num);

    void deleteById(Long id);

    List<Member> findAll();

    List<Member> search(String query);
}
