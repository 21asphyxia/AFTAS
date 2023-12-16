package com.imsouane.aftas.dto.rankingDTO;

import com.imsouane.aftas.domain.entities.Competition;
import com.imsouane.aftas.domain.entities.Member;
import com.imsouane.aftas.domain.entities.Ranking;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistrationRequestDto(
        @NotBlank String competitionCode,
        @NotNull Integer memberNum
) {
    public static Ranking toRanking(RegistrationRequestDto registrationRequestDto) {
        return Ranking.builder()
                .member(Member.builder().num(registrationRequestDto.memberNum()).build())
                .competition(Competition.builder().code(registrationRequestDto.competitionCode()).build())
                .build();
    }
}
