package com.imsouane.aftas.repository;

import com.imsouane.aftas.domain.Competition;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long> {
    public Optional<Competition> findByDate(@NotBlank LocalDate date);
}
