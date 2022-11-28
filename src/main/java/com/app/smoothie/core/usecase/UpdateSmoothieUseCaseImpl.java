package com.app.smoothie.core.usecase;

import com.app.smoothie.core.port.primary.usecase.UpdateSmoothieUseCase;
import com.app.smoothie.core.entity.Smoothie;
import com.app.smoothie.core.port.secondary.repository.SmoothieRepository;
import com.app.smoothie.core.port.primary.usecase.dto.SmoothieWithDetailsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateSmoothieUseCaseImpl implements UpdateSmoothieUseCase
{

    private final SmoothieRepository repository;

    @Override
    public SmoothieWithDetailsDto execute(UpdateSmoothieRequest request) {
        final Smoothie smoothie = repository.findById(request.getId());
        SmoothieUpdater.update(smoothie).with(request);
        final Smoothie saved = repository.save(smoothie);
        return new SmoothieWithDetailsDto(saved);
    }
}
