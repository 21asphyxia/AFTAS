package com.imsouane.aftas.service.dto.rankingDTO;

import com.imsouane.aftas.domain.entities.Competition;
import com.imsouane.aftas.domain.entities.Member;
import com.imsouane.aftas.domain.entities.Ranking;

public record RegistrationRequestDto(
        String competitionCode,
        Integer memberNum
) {
    public static Ranking toRanking(RegistrationRequestDto registrationRequestDto) {
        return Ranking.builder()
                .member(Member.builder().num(registrationRequestDto.memberNum()).build())
                .competition(Competition.builder().code(registrationRequestDto.competitionCode()).build())
                .build();
    }
}
