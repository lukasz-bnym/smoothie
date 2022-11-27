package com.app.smoothie.adapter.secondary.repository;

import com.app.smoothie.core.port.secondary.repository.SmoothieRepository;
import com.app.smoothie.core.entity.Smoothie;
import com.app.smoothie.core.sharedkernel.exception.SmoothieNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmoothieRepositoryImpl implements SmoothieRepository
{

    private final SmoothieStorage storage;

    @Override
    public List<Smoothie> findAll() {
        return storage.findAll().stream()
            .map(SmoothieData::toSmoothie)
            .collect(Collectors.toList());
    }

    @Override
    public Smoothie findById(UUID id) {
        return storage.findById(id)
            .map(SmoothieData::toSmoothie)
            .orElseThrow(() -> new SmoothieNotFoundException("Smoothie not found by id: " + id));
    }

    @Override
    public Smoothie save(Smoothie smoothie) {
        final SmoothieData saved = storage.save(new SmoothieData(smoothie));
        return saved.toSmoothie();
    }

    @Override
    public void delete(Smoothie smoothie) {
        storage.delete(new SmoothieData(smoothie));
    }
}
