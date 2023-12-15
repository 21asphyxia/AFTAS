package com.imsouane.aftas.repository;

import com.imsouane.aftas.domain.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByNum(Integer num);

    List<Member> findAll(Pageable pageable);
}
