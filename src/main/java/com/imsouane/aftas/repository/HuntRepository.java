package com.imsouane.aftas.repository;

import com.imsouane.aftas.domain.entities.Competition;
import com.imsouane.aftas.domain.entities.Fish;
import com.imsouane.aftas.domain.entities.Hunt;
import com.imsouane.aftas.domain.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HuntRepository extends JpaRepository<Hunt, Long> {
    Optional<Hunt> findByCompetitionAndFishAndMember(Competition competition, Fish fish, Member member);
}