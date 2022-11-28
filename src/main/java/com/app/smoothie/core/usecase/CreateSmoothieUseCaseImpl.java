package com.app.smoothie.core.usecase;

import com.app.smoothie.core.port.primary.usecase.CreateSmoothieUseCase;
import com.app.smoothie.core.entity.Smoothie;
import com.app.smoothie.core.port.secondary.repository.SmoothieRepository;
import com.app.smoothie.core.port.primary.usecase.dto.SmoothieDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateSmoothieUseCaseImpl implements CreateSmoothieUseCase
{

    private final SmoothieRepository repository;

    @Override
    public SmoothieDto execute(CreateSmoothieRequest request) {
        final UUID id = UUID.randomUUID();
        final Smoothie smoothie = new Smoothie(id, request.getName());
        final Smoothie saved = repository.save(smoothie);
        return new SmoothieDto(saved);
    }
}
