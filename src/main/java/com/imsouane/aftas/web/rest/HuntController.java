package com.imsouane.aftas.web.rest;

import com.imsouane.aftas.domain.entities.Hunt;
import com.imsouane.aftas.service.dto.huntDTO.HuntCreationRequestDto;
import com.imsouane.aftas.service.dto.huntDTO.HuntResponseDto;
import com.imsouane.aftas.service.impl.HuntServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/hunts")
public class HuntController {
    private final HuntServiceImpl huntService;

    @PostMapping
    public ResponseEntity<HuntResponseDto> save(@RequestBody @Valid HuntCreationRequestDto hunt) {
        Hunt toCreateHunt = HuntCreationRequestDto.toHunt(hunt);
        Hunt savedHunt = huntService.save(toCreateHunt, hunt.weight());
        return ResponseEntity.created(URI.create("/api/v1/hunts/" + savedHunt.getId())).body(HuntResponseDto.fromHunt(savedHunt));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HuntResponseDto> findById(@PathVariable Long id) {
        HuntResponseDto huntResponseDto = HuntResponseDto.fromHunt(huntService.findById(id));
        return ResponseEntity.ok(huntResponseDto);
    }
}
