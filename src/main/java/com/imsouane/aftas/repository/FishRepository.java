package com.imsouane.aftas.repository;

import com.imsouane.aftas.domain.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FishRepository extends JpaRepository<Fish, Long> {
}
