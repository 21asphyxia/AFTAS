package com.imsouane.aftas.dto.huntDTO;

import com.imsouane.aftas.domain.entities.Hunt;
import lombok.Builder;

@Builder
public record HuntResponseDto(Long id,
                              String competition_code,
                              String fish_name,
                              Double fish_averageWeight,
                              Integer numberOfFish,
                              Integer member_number,
                              String member_name) {

    public static HuntResponseDto fromHunt(Hunt hunt) {
        return HuntResponseDto.builder()
                .id(hunt.getId())
                .competition_code(hunt.getCompetition().getCode())
                .fish_name(hunt.getFish().getName())
                .fish_averageWeight(hunt.getFish().getAverageWeight())
                .numberOfFish(hunt.getNumberOfFish())
                .member_number(hunt.getMember().getNum())
                .member_name(hunt.getMember().getName())
                .build();
    }
}
