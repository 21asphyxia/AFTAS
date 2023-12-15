package com.imsouane.aftas.web.rest;

import com.imsouane.aftas.service.dto.competitionDTO.CompetitionRankingsResponseDto;
import com.imsouane.aftas.service.dto.rankingDTO.RankingResponseDto;
import com.imsouane.aftas.service.dto.rankingDTO.RegistrationRequestDto;
import com.imsouane.aftas.service.impl.RankingServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/rankings")
@RequiredArgsConstructor
public class RankingController {
    private final RankingServiceImpl rankingService;

    @PostMapping
    public ResponseEntity<RankingResponseDto> registerMember(@RequestBody RegistrationRequestDto registrationRequestDto) {
        return ResponseEntity.ok(RankingResponseDto.fromRanking(rankingService.registerMember(RegistrationRequestDto.toRanking(registrationRequestDto))));
    }


    @GetMapping("/competitions/{code}")
    public ResponseEntity<CompetitionRankingsResponseDto> findByCompetitionCode(@PathVariable String code) {
        return ResponseEntity.ok(CompetitionRankingsResponseDto.fromCompetitionAndRankings(code, RankingResponseDto.fromRankings(rankingService.findByCompetitionCode(code))));
    }

    @GetMapping("/competitions/{code}/podium")
    public ResponseEntity<CompetitionRankingsResponseDto> findPodiumByCompetitionCode(@PathVariable String code) {
        return ResponseEntity.ok(CompetitionRankingsResponseDto.fromCompetitionAndRankings(code, RankingResponseDto.fromRankings(rankingService.findPodiumByCompetitionCode(code))));
    }


}
