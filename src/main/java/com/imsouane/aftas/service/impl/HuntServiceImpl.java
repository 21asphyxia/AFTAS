package com.imsouane.aftas.service.impl;

import com.imsouane.aftas.domain.entities.Hunt;
import com.imsouane.aftas.repository.HuntRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HuntServiceImpl {
    private final HuntRepository huntRepository;
    private final FishServiceImpl fishService;

    public Hunt save(Hunt hunt) {
        if (hunt.getFish().getAverageWeight()
        Optional<Hunt> savedHunt = huntRepository.findByCompetitionAndFishAndMember(hunt.getCompetition(), hunt.getFish(), hunt.getMember());

        if (savedHunt.isPresent()) {
            Hunt toUpdateHunt = savedHunt.get();
            toUpdateHunt
        }
    }
