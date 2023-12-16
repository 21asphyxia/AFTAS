package com.imsouane.aftas.dto.rankingDTO;

import com.imsouane.aftas.domain.entities.Ranking;
import lombok.Builder;

import java.util.List;

@Builder
public record RankingResponseDto(
        Integer member_number,
        String member_fullName,
        Integer rank,
        Integer score

) {
    public static RankingResponseDto fromRanking(Ranking ranking) {
        return RankingResponseDto.builder()
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
