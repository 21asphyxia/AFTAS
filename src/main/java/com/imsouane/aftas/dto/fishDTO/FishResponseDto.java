package com.imsouane.aftas.dto.fishDTO;

import com.imsouane.aftas.domain.entities.Fish;
import lombok.Builder;

import java.util.List;

@Builder
public record FishResponseDto(Long id, String name, Double averageWeight, String level) {

    public static FishResponseDto fromFish(Fish fish) {
        return FishResponseDto.builder()
                .id(fish.getId())
                .name(fish.getName())
                .averageWeight(fish.getAverageWeight())
                .level(fish.getLevel().getDescription())
                .build();
    }

    public static List<FishResponseDto> fromFishes(List<Fish> fishes) {
        return fishes.stream().map(FishResponseDto::fromFish).toList();
    }
}
