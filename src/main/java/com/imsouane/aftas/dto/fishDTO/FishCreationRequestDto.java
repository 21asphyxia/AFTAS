package com.imsouane.aftas.dto.fishDTO;

import com.imsouane.aftas.domain.entities.Fish;
import com.imsouane.aftas.domain.entities.Level;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FishCreationRequestDto(@NotBlank(message = "Fish name is mandatory") String name,
                                     @NotNull(message = "Fish average weight is mandatory") Double averageWeight,
                                     @NotNull(message = "Fish level is mandatory") Long levelId) {

    public static Fish toFish(FishCreationRequestDto fishCreationRequestDto) {
        return Fish.builder().name(fishCreationRequestDto.name()).averageWeight(fishCreationRequestDto.averageWeight()).level(Level.builder().id(fishCreationRequestDto.levelId()).build()).build();
    }
}
