package com.imsouane.aftas.repository;

import com.imsouane.aftas.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
