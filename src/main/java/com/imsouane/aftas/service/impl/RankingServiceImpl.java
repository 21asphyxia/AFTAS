package com.imsouane.aftas.service.impl;

import com.imsouane.aftas.domain.entities.Competition;
import com.imsouane.aftas.domain.entities.Fish;
import com.imsouane.aftas.domain.entities.Member;
import com.imsouane.aftas.domain.entities.Ranking;
import com.imsouane.aftas.domain.entities.embeddable.RankId;
import com.imsouane.aftas.exception.RankingCreationException;
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

    public List<Ranking> findByCompetition(String code) {
        Competition competition = competitionService.findByCode(code);
        return rankingRepository.findByCompetitionOrderByScoreDesc(competition);
    }

    public Ranking registerMember(Ranking ranking) {
        Competition competition = competitionService.findByCode(ranking.getCompetition().getCode());
        Member member = memberService.findByNum(ranking.getMember().getNum());
        if (competition.getNumberOfParticipants() <= getCurrentNumberOfParticipants(competition.getCode())) {
            throw new RankingCreationException("Competition is full");
        }
        if (rankingRepository.existsByCompetitionCodeAndMemberNum(competition.getCode(), member.getNum())) {
            throw new RankingCreationException("Member already registered in this competition");
        }
        if (LocalDateTime.of(competition.getDate(), competition.getStartTime()).minusHours(24).isBefore(LocalDateTime.now())) {
            throw new RankingCreationException("Registration is closed");
        }
        ranking.setId(new RankId(member.getId(), competition.getCode()));
        ranking.setMember(member);
        ranking.setCompetition(competition);
        ranking.setScore(0);
        ranking.setRank(getCurrentNumberOfParticipants(competition.getCode()) + 1);
        return rankingRepository.save(ranking);
    }

    public void updateRankingScoreAndRank(Member member, Competition competition, Fish fish) {
        Ranking ranking = rankingRepository.findByCompetitionCodeAndMemberNum(competition.getCode(), member.getNum()).orElseThrow(() -> new RankingCreationException("Member not registered in this competition"));
        ranking.setScore(ranking.getScore() + fish.getLevel().getPoints());
        rankingRepository.save(ranking);
        List<Ranking> rankings = rankingRepository.findByCompetitionCodeOrderByScoreDesc(competition.getCode());
        rankings.forEach(r -> r.setRank(rankings.indexOf(r) + 1));
        rankingRepository.saveAll(rankings);
    }

    public Integer getCurrentNumberOfParticipants(String code) {
        return rankingRepository.countByCompetitionCode(code);
    }

    public List<Ranking> findPodiumByCompetitionCode(String code) {
        List<Ranking> rankings = rankingRepository.findTop3ByCompetitionCodeOrderByScoreDesc(code);
        if (rankings.isEmpty()) {
            throw new RankingCreationException("No podium found");
        } else {
            return rankings;
        }
    }
}
