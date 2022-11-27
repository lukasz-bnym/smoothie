package com.app.smoothie.core.usecase;

import com.app.smoothie.core.port.primary.usecase.GetSmoothieDetailsService;
import com.app.smoothie.core.entity.Smoothie;
import com.app.smoothie.core.port.secondary.repository.SmoothieRepository;
import com.app.smoothie.core.port.primary.usecase.dto.EntityRequest;
import com.app.smoothie.core.port.primary.usecase.dto.SmoothieWithDetailsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetSmoothieDetailsServiceImpl implements GetSmoothieDetailsService {

    private final SmoothieRepository repository;

    @Override
    public SmoothieWithDetailsDto execute(EntityRequest request) {
        final Smoothie smoothie = repository.findById(request.getId());
        return new SmoothieWithDetailsDto(smoothie);
    }
}
