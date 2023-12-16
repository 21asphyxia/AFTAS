package com.imsouane.aftas.service;

import com.imsouane.aftas.domain.entities.Hunt;

public interface HuntService {
    Hunt save(Hunt hunt, Double weight);

    Hunt findById(Long id);
}
