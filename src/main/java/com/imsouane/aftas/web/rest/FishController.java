package com.imsouane.aftas.web.rest;

import com.imsouane.aftas.domain.entities.Fish;
import com.imsouane.aftas.dto.fishDTO.FishCreationRequestDto;
import com.imsouane.aftas.dto.fishDTO.FishResponseDto;
import com.imsouane.aftas.service.FishService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/fishes")
public class FishController {

    private final FishService fishService;

    @PostMapping
    public ResponseEntity<FishResponseDto> save(@RequestBody @Valid FishCreationRequestDto fish) {
        Fish toCreateFish = FishCreationRequestDto.toFish(fish);
        Fish savedFish = fishService.save(toCreateFish);
        return ResponseEntity.created(URI.create("/api/v1/fishes/" + savedFish.getId())).body(FishResponseDto.fromFish(savedFish));
    }

    @GetMapping
    public ResponseEntity<List<FishResponseDto>> findAll() {
        return ResponseEntity.ok(FishResponseDto.fromFishes(fishService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FishResponseDto> findById(@PathVariable Long id) {
        FishResponseDto fishResponseDto = FishResponseDto.fromFish(fishService.findById(id));
        return ResponseEntity.ok(fishResponseDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        fishService.deleteById(id);
    }

}
