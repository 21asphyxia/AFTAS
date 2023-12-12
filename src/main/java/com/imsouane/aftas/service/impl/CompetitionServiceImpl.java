package com.imsouane.aftas.service.impl;

import com.imsouane.aftas.domain.Competition;
import com.imsouane.aftas.exception.CompetitionCreationException;
import com.imsouane.aftas.exception.ResourceNotFoundException;
import com.imsouane.aftas.repository.CompetitionRepository;
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

    public Competition save(Competition competition) {
        competitionRepository.findByDate(competition.getDate()).orElseThrow(() -> new CompetitionCreationException("Competition already exists for this date"));
        return competitionRepository.save(competition);
    }

    public List<Competition> findAll() {
        return competitionRepository.findAll();
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

    public Competition findByCode(String code) {
        return competitionRepository.findByCodeLikeIgnoreCase(code).orElseThrow(() -> new ResourceNotFoundException("Competition not found with code: " + code));
    }
}
