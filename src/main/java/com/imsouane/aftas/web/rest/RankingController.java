package com.imsouane.aftas.web.rest;

import com.imsouane.aftas.service.dto.rankingDTO.RankingResponseDto;
import com.imsouane.aftas.service.impl.RankingServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rankings")
@RequiredArgsConstructor
public class RankingController {
    private final RankingServiceImpl rankingService;

    @GetMapping("/competitions/{code}")
    public ResponseEntity<List<RankingResponseDto>> findByCompetitionCode(@PathVariable String code) {
        return ResponseEntity.ok(RankingResponseDto.fromRankings(rankingService.findByCompetitionCode(code)));
    }
}
