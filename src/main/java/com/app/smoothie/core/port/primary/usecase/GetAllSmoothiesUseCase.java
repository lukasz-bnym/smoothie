package com.app.smoothie.core.port.primary.usecase;

import com.app.smoothie.core.port.primary.usecase.dto.SmoothieDto;
import java.util.List;

public interface GetAllSmoothiesUseCase
{
    List<SmoothieDto> execute();
}
