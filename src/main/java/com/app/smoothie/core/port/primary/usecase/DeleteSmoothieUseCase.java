package com.app.smoothie.core.port.primary.usecase;

import com.app.smoothie.core.port.primary.usecase.dto.EntityRequest;

public interface DeleteSmoothieUseCase
{
    void execute(EntityRequest request);
}
