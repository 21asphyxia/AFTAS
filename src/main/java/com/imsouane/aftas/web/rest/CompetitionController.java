package com.imsouane.aftas.web.rest;

import com.imsouane.aftas.domain.entities.Competition;
import com.imsouane.aftas.service.dto.competitionDTO.CompetitionCreationRequestDto;
import com.imsouane.aftas.service.impl.CompetitionServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/competitions")
public class CompetitionController {

    private final CompetitionServiceImpl competitionService;

    @PostMapping
    public Competition save(@RequestBody @Valid CompetitionCreationRequestDto competition) {
        Competition toCreateCompetition = CompetitionCreationRequestDto.toCompetition(competition);
        return competitionService.save(toCreateCompetition);
    }

    @GetMapping("/{code}")
    public Competition findByCode(@PathVariable String code) {
        return competitionService.findByCode(code);
    }
}
