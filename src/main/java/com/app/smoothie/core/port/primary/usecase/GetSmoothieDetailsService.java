package com.app.smoothie.core.port.primary.usecase;

import com.app.smoothie.core.port.primary.usecase.dto.EntityRequest;
import com.app.smoothie.core.port.primary.usecase.dto.SmoothieWithDetailsDto;

public interface GetSmoothieDetailsService {
    SmoothieWithDetailsDto execute(EntityRequest request);
}
