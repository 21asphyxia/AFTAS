package com.imsouane.aftas.repository;

import com.imsouane.aftas.domain.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query(value =
            "SELECT * FROM member WHERE CAST(num AS TEXT) = :searchTerm OR name ILIKE %:searchTerm% OR family_name ILIKE %:searchTerm%", nativeQuery = true)
    List<Member> findByMembershipNumberOrNameOrFamilyName(@Param("searchTerm") String searchTerm);

    Optional<Member> findByNum(Integer num);
}
