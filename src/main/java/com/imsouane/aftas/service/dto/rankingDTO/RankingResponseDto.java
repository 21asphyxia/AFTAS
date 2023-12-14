package com.imsouane.aftas.service.dto.rankingDTO;

import com.imsouane.aftas.domain.entities.Ranking;
import lombok.Builder;

import java.util.List;

@Builder
public record RankingResponseDto(
        String competition_code,
        Integer member_number,
        String member_fullName,
        Integer rank,
        Integer score

) {
    public static RankingResponseDto fromRanking(Ranking ranking) {
        return RankingResponseDto.builder()
                .competition_code(ranking.getCompetition().getCode())
                .member_number(ranking.getMember().getNum())
                .member_fullName(ranking.getMember().getName() + " " + ranking.getMember().getFamilyName())
                .rank(ranking.getRank())
                .score(ranking.getScore())
                .build();
    }

    public static List<RankingResponseDto> fromRankings(List<Ranking> rankings) {
        return rankings.stream().map(RankingResponseDto::fromRanking).toList();
    }
}
