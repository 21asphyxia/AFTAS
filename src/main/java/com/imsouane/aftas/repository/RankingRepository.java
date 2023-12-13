package com.imsouane.aftas.repository;

import com.imsouane.aftas.domain.entities.Ranking;
import com.imsouane.aftas.domain.entities.embeddable.RankId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankingRepository extends JpaRepository<Ranking, RankId> {
}
