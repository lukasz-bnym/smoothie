package com.app.smoothie.core.usecase;

import com.app.smoothie.core.port.primary.usecase.GetAllSmoothiesUseCase;
import com.app.smoothie.core.port.secondary.repository.SmoothieRepository;
import com.app.smoothie.core.port.primary.usecase.dto.SmoothieDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllSmoothiesUseCaseImpl implements GetAllSmoothiesUseCase
{

    private final SmoothieRepository repository;

    @Override
    public List<SmoothieDto> execute() {
        return repository.findAll().stream()
            .map(SmoothieDto::new)
            .collect(Collectors.toList());
    }
}
