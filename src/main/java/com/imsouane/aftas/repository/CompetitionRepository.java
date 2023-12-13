package com.imsouane.aftas.repository;

import com.imsouane.aftas.domain.entities.Competition;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, String> {

    List<Competition> findAllByOrderByDateDesc(Pageable pageable);

    Optional<Competition> findByDate(@NotBlank LocalDate date);

    Optional<Competition> findByCodeLikeIgnoreCase(@NotBlank String code);
}
