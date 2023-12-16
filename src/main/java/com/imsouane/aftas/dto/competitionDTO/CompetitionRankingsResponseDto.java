package com.imsouane.aftas.dto.competitionDTO;

import com.imsouane.aftas.dto.rankingDTO.RankingResponseDto;
import lombok.Builder;

import java.util.List;

@Builder
public record CompetitionRankingsResponseDto(
        String code,
        List<RankingResponseDto> rankings
) {
    public static CompetitionRankingsResponseDto fromCompetitionAndRankings(String code, List<RankingResponseDto> rankings) {
        return CompetitionRankingsResponseDto.builder()
                .code(code)
                .rankings(rankings)
                .build();
    }
}
