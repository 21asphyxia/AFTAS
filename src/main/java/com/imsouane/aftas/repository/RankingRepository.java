package com.imsouane.aftas.repository;

import com.imsouane.aftas.domain.entities.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankingRepository extends JpaRepository<Ranking, Long> {
}
