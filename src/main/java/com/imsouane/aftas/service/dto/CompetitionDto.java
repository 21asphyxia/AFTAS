package com.imsouane.aftas.service.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Value
@Builder
public class CompetitionDto implements Serializable {
    @Pattern(message = "Code must be in the format of sss-dd-mm-yy", regexp = "^[a-z]{3}-[0-9]{2}-[0-9]{2}-[0-9]{2}$")
    @NotBlank
    String code;
    @NotNull
    @FutureOrPresent(message = "Date must be in the future or present")
    LocalDate date;
    @NotNull
    LocalTime startTime;
    @NotNull
    LocalTime endTime;
    @NotNull
    @Min(value = 2, message = "Number of participants must be at least 2")
    Integer numberOfParticipants;
    @NotBlank
    String location;
}