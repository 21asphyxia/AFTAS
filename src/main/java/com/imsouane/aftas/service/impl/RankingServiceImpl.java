package com.imsouane.aftas.service.impl;

import com.imsouane.aftas.domain.entities.Competition;
import com.imsouane.aftas.domain.entities.Member;
import com.imsouane.aftas.domain.entities.Ranking;
import com.imsouane.aftas.repository.RankingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        if (rankingRepository.findByCompetitionCodeAndMemberNum(competition.getCode(), member.getNum()).isPresent()) {
            throw new RuntimeException("Member already registered in this competition");
        }
        ranking.setMember(member);
        ranking.setCompetition(competition);

    }

    public Integer getCurrentNumberOfParticipants(String code) {
        return rankingRepository.findByCompetitionCode(code).size();
    }
}
