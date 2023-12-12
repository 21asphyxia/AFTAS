package com.imsouane.aftas.service.dto.fishDTO;

import com.imsouane.aftas.domain.Fish;
import lombok.Builder;

@Builder
public record FishResponseDto(Long id, String name, Double averageWeight, String level) {

    public static FishResponseDto fromFish(Fish fish) {
        return FishResponseDto.builder().id(fish.getId()).name(fish.getName()).averageWeight(fish.getAverageWeight()).level(fish.getLevel().getDescription()).build();
    }
}
