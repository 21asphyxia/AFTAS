package com.imsouane.aftas.service.impl;

import com.imsouane.aftas.domain.Competition;
import com.imsouane.aftas.exception.CompetitionCreationException;
import com.imsouane.aftas.repository.CompetitionRepository;
import com.imsouane.aftas.service.dto.competitionDTO.CompetitionCreationRequestDto;
import com.imsouane.aftas.service.dto.competitionDTO.CompetitionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompetitionServiceImpl {
    private final CompetitionRepository competitionRepository;

    public CompetitionResponseDto save(CompetitionCreationRequestDto competition) {
        Competition toCreateCompetition = CompetitionCreationRequestDto.toCompetition(competition);
        Competition existingCompetition = competitionRepository.findByDate(toCreateCompetition.getDate())
                .orElse(null);
        if (existingCompetition != null) {
            throw new CompetitionCreationException("Competition already exists for this date");
        }
        return CompetitionResponseDto.fromCompetition(competitionRepository.save(toCreateCompetition));
    }

    public List<CompetitionResponseDto> findAll() {
        return CompetitionResponseDto.fromCompetitions(competitionRepository.findAll());
    }

    public Optional<Competition> findById(Long id) {
        return competitionRepository.findById(id);
    }

    public void delete(Competition competition) {
        competitionRepository.delete(competition);
    }

    public Page<Competition> findAll(Pageable pageable) {
        return competitionRepository.findAll(pageable);
    }

}
