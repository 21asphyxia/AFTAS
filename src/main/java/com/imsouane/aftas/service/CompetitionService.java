package com.imsouane.aftas.service;

import com.imsouane.aftas.domain.entities.Competition;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompetitionService {
    List<Competition> findAll(Pageable pageable);

    Competition save(@Valid Competition competition);

    Competition findByCode(String code);

    void delete(Competition competition);

    Long count();
}
