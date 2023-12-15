package com.imsouane.aftas.service.impl;

import com.imsouane.aftas.domain.entities.Competition;
import com.imsouane.aftas.domain.entities.Fish;
import com.imsouane.aftas.domain.entities.Hunt;
import com.imsouane.aftas.domain.entities.Member;
import com.imsouane.aftas.exception.HuntCreationException;
import com.imsouane.aftas.repository.HuntRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class HuntServiceImpl {
    private final HuntRepository huntRepository;
    private final FishServiceImpl fishService;
    private final CompetitionServiceImpl competitionService;
    private final MemberServiceImpl memberService;
    private final RankingServiceImpl rankingService;

    public Hunt save(Hunt hunt, Double weight) {
        Fish fish = fishService.findById(hunt.getFish().getId());
        Member member = memberService.findById(hunt.getMember().getId());
        Competition competition = competitionService.findByCode(hunt.getCompetition().getCode());
        if (competition.getDate().isEqual(LocalDate.now())) {
            throw new HuntCreationException("Hunts can only be registered on the day of the competition");
        }
        if (fish.getAverageWeight() <= weight) {
            Hunt hunt1 = huntRepository.findByCompetitionAndFishAndMember(competition, fish, member).orElse(null);
            if (hunt1 == null) {
                hunt1 = Hunt.builder()
                        .competition(competition)
                        .fish(fish)
                        .member(member)
                        .numberOfFish(1)
                        .build();
            } else {
                hunt1.setNumberOfFish(hunt1.getNumberOfFish() + 1);
            }
            rankingService.updateRankingScoreAndRank(member, competition, fish);
            return huntRepository.save(hunt1);
        } else {
            throw new HuntCreationException("Weight is less than average weight");
        }
    }

    public Hunt findById(Long id) {
        return huntRepository.findById(id).orElseThrow(() -> new HuntCreationException("Hunt not found"));
    }
}