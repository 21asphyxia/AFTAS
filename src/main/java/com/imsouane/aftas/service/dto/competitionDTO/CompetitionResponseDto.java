package com.imsouane.aftas.service.dto.competitionDTO;

import com.imsouane.aftas.domain.entities.Competition;

import java.util.List;

public record CompetitionResponseDto(String code, String date, String startTime, String endTime,
                                     Integer numberOfParticipants, String location) {
    public static CompetitionResponseDto fromCompetition(Competition competition) {
        return new CompetitionResponseDto(competition.getCode(), competition.getDate().toString(), competition.getStartTime().toString(), competition.getEndTime().toString(), competition.getNumberOfParticipants(), competition.getLocation());
    }

    public static List<CompetitionResponseDto> fromCompetitions(List<Competition> competitions) {
        return competitions.stream().map(CompetitionResponseDto::fromCompetition).toList();
    }
}
