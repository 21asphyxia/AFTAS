package com.imsouane.aftas.service.impl;

import com.imsouane.aftas.domain.entities.Fish;
import com.imsouane.aftas.exception.ResourceNotFoundException;
import com.imsouane.aftas.repository.FishRepository;
import com.imsouane.aftas.service.FishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FishServiceImpl implements FishService {

    private final FishRepository fishRepository;

    @Override
    public Fish save(Fish fish) {
        return fishRepository.save(fish);
    }

    @Override
    public Fish findById(Long id) {
        return fishRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Fish not found"));
    }

    @Override
    public void deleteById(Long id) {
        Fish fish = findById(id);
        fishRepository.delete(fish);
    }

    @Override
    public void delete(Fish entity) {
        fishRepository.delete(entity);
    }

    @Override
    public List<Fish> findAll() {
        return fishRepository.findAll();
    }
}
