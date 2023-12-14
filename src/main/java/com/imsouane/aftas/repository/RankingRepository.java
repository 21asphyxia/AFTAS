package com.imsouane.aftas.repository;

import com.imsouane.aftas.domain.entities.Ranking;
import com.imsouane.aftas.domain.entities.embeddable.RankId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RankingRepository extends JpaRepository<Ranking, RankId> {
    List<Ranking> findByCompetitionCode(String code);

    Optional<Ranking> findByCompetitionCodeAndMemberNum(String code, Integer num);

    Boolean existsByCompetitionCodeAndMemberNum(String code, Integer num);
}
