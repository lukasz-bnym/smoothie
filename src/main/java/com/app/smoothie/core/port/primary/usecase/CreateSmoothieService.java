package com.app.smoothie.core.port.primary.usecase;

import com.app.smoothie.core.port.primary.usecase.dto.SmoothieDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public interface CreateSmoothieService
{
    SmoothieDto execute(CreateSmoothieRequest request);

    @Getter
    @RequiredArgsConstructor
    class CreateSmoothieRequest {
        private final String name;
    }
}
