package com.imsouane.aftas.web.rest;

import com.imsouane.aftas.service.dto.competitionDTO.CompetitionCreationRequestDto;
import com.imsouane.aftas.service.dto.competitionDTO.CompetitionResponseDto;
import com.imsouane.aftas.service.impl.CompetitionServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/competitions")
public class CompetitionController {

    private final CompetitionServiceImpl competitionService;

    @PostMapping
    public CompetitionResponseDto save(@RequestBody @Valid CompetitionCreationRequestDto competition) {
        return competitionService.save(competition);
    }
}
