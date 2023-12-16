package com.imsouane.aftas.dto.huntDTO;

import com.imsouane.aftas.domain.entities.Competition;
import com.imsouane.aftas.domain.entities.Fish;
import com.imsouane.aftas.domain.entities.Hunt;
import com.imsouane.aftas.domain.entities.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record HuntCreationRequestDto(
        @NotBlank(message = "Competition code is mandatory")
        String competition_code,
        @NotNull(message = "Fish ID is mandatory")
        Long fishId,
        @NotNull(message = "Member ID is mandatory")
        Integer memberNum,
        @NotNull(message = "Weight is mandatory")
        Double weight) {

    public static Hunt toHunt(HuntCreationRequestDto huntCreationRequestDto) {
        return Hunt.builder()
                .competition(Competition.builder().code(huntCreationRequestDto.competition_code()).build())
                .fish(Fish.builder().id(huntCreationRequestDto.fishId()).build())
                .member(Member.builder().num(huntCreationRequestDto.memberNum()).build())
                .build();
    }
}
