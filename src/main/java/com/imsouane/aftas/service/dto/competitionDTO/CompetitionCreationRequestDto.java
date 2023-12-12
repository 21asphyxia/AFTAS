package com.imsouane.aftas.service.dto.competitionDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.imsouane.aftas.domain.Competition;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalTime;

public record CompetitionCreationRequestDto(
        @Pattern(message = "Code must be in the format of sss-dd-mm-yy", regexp = "^[a-z]{3}-[0-9]{2}-[0-9]{2}-[0-9]{2}$") @NotBlank String code,
        @NotNull @JsonFormat(pattern = "dd-MM-yyyy") @FutureOrPresent(message = "Date must be in the future or present") LocalDate date,
        @NotNull LocalTime startTime, @NotNull LocalTime endTime,
        @NotNull @Min(value = 2, message = "Number of participants must be at least 2") Integer numberOfParticipants,
        @NotBlank String location) {

    public static Competition toCompetition(CompetitionCreationRequestDto competitionCreationRequestDto) {
        return Competition.builder().code(competitionCreationRequestDto.code()).date(competitionCreationRequestDto.date()).startTime(competitionCreationRequestDto.startTime()).endTime(competitionCreationRequestDto.endTime()).numberOfParticipants(competitionCreationRequestDto.numberOfParticipants()).location(competitionCreationRequestDto.location()).build();
    }
}