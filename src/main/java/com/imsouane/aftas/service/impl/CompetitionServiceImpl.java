package com.imsouane.aftas.service.impl;

import com.imsouane.aftas.domain.entities.Competition;
import com.imsouane.aftas.exception.CompetitionCreationException;
import com.imsouane.aftas.exception.ResourceNotFoundException;
import com.imsouane.aftas.repository.CompetitionRepository;
import com.imsouane.aftas.service.CompetitionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompetitionServiceImpl implements CompetitionService {
    private final CompetitionRepository competitionRepository;

    @Override
    public List<Competition> findAll(Pageable pageable) {
        return competitionRepository.findAllByOrderByDateDesc(pageable);
    }

    @Override
    public Competition save(@Valid Competition competition) {
        competitionRepository.findByDate(competition.getDate()).ifPresent((c) -> {
            throw new CompetitionCreationException("Competition already exists with date: " + competition.getDate());
        });
        competition.setCode(generateCode(competition.getLocation().toLowerCase(), competition.getDate()));
        return competitionRepository.save(competition);
    }

    @Override
    public Competition findByCode(String code) {
        return competitionRepository.findByCodeLikeIgnoreCase(code).orElseThrow(() -> new ResourceNotFoundException("Competition not found with code: " + code));
    }

    @Override
    public void delete(Competition competition) {
        competitionRepository.delete(competition);
    }

    private String generateCode(String location, LocalDate date) {
        return location.substring(0, 3) + "-" + date.getDayOfMonth() + "-" + date.getMonthValue() + "-" + String.valueOf(date.getYear()).substring(2);
    }
}
