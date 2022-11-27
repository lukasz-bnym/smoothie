package com.app.smoothie.core.port.primary.usecase;

import com.app.smoothie.core.port.primary.usecase.dto.SmoothieDto;
import java.util.List;

public interface GetAllSmoothiesService
{
    List<SmoothieDto> execute();
}
