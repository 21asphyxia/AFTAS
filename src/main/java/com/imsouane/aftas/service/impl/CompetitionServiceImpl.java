package com.imsouane.aftas.service.impl;

import com.imsouane.aftas.domain.Competition;
import com.imsouane.aftas.repository.CompetitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CompetitionServiceImpl {
    private final CompetitionRepository competitionRepository;

    public List<Competition> findAll() {
        return competitionRepository.findAll();
    }

    public Competition save(Competition competition) {
        return competitionRepository.save(competition);
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
