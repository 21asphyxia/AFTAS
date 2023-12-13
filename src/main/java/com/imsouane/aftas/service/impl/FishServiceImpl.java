package com.imsouane.aftas.service.impl;

import com.imsouane.aftas.domain.entities.Fish;
import com.imsouane.aftas.exception.ResourceNotFoundException;
import com.imsouane.aftas.repository.FishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FishServiceImpl {

    private final FishRepository fishRepository;

    public Fish save(Fish fish) {
        return fishRepository.save(fish);
    }

    public Fish findById(Long id) {
        return fishRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Fish not found"));
    }

    public void deleteById(Long id) {
        Fish fish = findById(id);
        fishRepository.delete(fish);
    }

    public void delete(Fish entity) {
        fishRepository.delete(entity);
    }
}
