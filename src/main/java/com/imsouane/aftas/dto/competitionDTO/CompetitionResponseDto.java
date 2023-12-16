package com.imsouane.aftas.dto.competitionDTO;

import com.imsouane.aftas.domain.entities.Competition;
import lombok.Builder;

import java.util.List;

@Builder
public record CompetitionResponseDto(String code, String date, String startTime, String endTime,
                                     Integer numberOfParticipants, String location) {
    public static CompetitionResponseDto fromCompetition(Competition competition) {
        return CompetitionResponseDto.builder()
                .code(competition.getCode())
                .date(competition.getDate().toString())
                .startTime(competition.getStartTime().toString())
                .endTime(competition.getEndTime().toString())
                .numberOfParticipants(competition.getNumberOfParticipants())
                .location(competition.getLocation())
                .build();
    }

    public static List<CompetitionResponseDto> fromCompetitions(List<Competition> competitions) {
        return competitions.stream().map(CompetitionResponseDto::fromCompetition).toList();
    }
}
