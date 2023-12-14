package com.imsouane.aftas.service.impl;

import com.imsouane.aftas.domain.entities.Competition;
import com.imsouane.aftas.domain.entities.Fish;
import com.imsouane.aftas.domain.entities.Member;
import com.imsouane.aftas.domain.entities.Ranking;
import com.imsouane.aftas.repository.RankingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RankingServiceImpl {
    private final RankingRepository rankingRepository;
    private final CompetitionServiceImpl competitionService;
    private final MemberServiceImpl memberService;

    public List<Ranking> findByCompetitionCode(String code) {
        return rankingRepository.findByCompetitionCode(code);
    }

    public Ranking registerMember(Ranking ranking) {
        Competition competition = competitionService.findByCode(ranking.getCompetition().getCode());
        Member member = memberService.findByNum(ranking.getMember().getNum());
        if (rankingRepository.existsByCompetitionCodeAndMemberNum(competition.getCode(), member.getNum())) {
            throw new RuntimeException("Member already registered in this competition");
        }
        if (LocalDateTime.of(competition.getDate(), competition.getStartTime()).minusHours(24).isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Registration is closed");
        }
        ranking.setMember(member);
        ranking.setCompetition(competition);
        return rankingRepository.save(ranking);
    }

    public void updateRankingScoreAndRank(Member member, Competition competition, Fish fish) {
        Ranking ranking = rankingRepository.findByCompetitionCodeAndMemberNum(competition.getCode(), member.getNum()).orElseThrow(() -> new RuntimeException("Member not registered in this competition"));
        ranking.setScore(ranking.getScore() + fish.getLevel().getPoints());\

    }

    public Integer getCurrentNumberOfParticipants(String code) {
        return rankingRepository.findByCompetitionCode(code).size();
    }
}
