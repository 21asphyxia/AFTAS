package com.imsouane.aftas.dto.competitionDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.imsouane.aftas.domain.entities.Competition;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

public record CompetitionCreationRequestDto(
        @NotNull @JsonFormat(pattern = "yyyy-MM-dd") @Future(message = "Date must be in the future") LocalDate date,
        @NotNull LocalTime startTime, @NotNull LocalTime endTime,
        @NotNull @Min(value = 2, message = "Number of participants must be at least 2") Integer numberOfParticipants,
        @NotBlank String location) {

    public static Competition toCompetition(CompetitionCreationRequestDto competitionCreationRequestDto) {
        return Competition.builder()
                .date(competitionCreationRequestDto.date())
                .startTime(competitionCreationRequestDto.startTime())
                .endTime(competitionCreationRequestDto.endTime())
                .numberOfParticipants(competitionCreationRequestDto.numberOfParticipants())
                .location(competitionCreationRequestDto.location())
                .build();
    }
}