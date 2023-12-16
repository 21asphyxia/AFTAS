package com.imsouane.aftas.service;

import com.imsouane.aftas.domain.entities.Competition;
import com.imsouane.aftas.domain.entities.Fish;
import com.imsouane.aftas.domain.entities.Member;
import com.imsouane.aftas.domain.entities.Ranking;

import java.util.List;

public interface RankingService {
    List<Ranking> findByCompetitionCode(String code);

    List<Ranking> findByCompetition(String code);

    Ranking registerMember(Ranking ranking);

    void updateRankingScoreAndRank(Member member, Competition competition, Fish fish);

    Integer getCurrentNumberOfParticipants(String code);

    List<Ranking> findPodiumByCompetitionCode(String code);
}
