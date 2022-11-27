package com.app.smoothie.core.port.primary.usecase.dto;

import com.app.smoothie.core.entity.Smoothie;
import java.util.UUID;
import lombok.Getter;

@Getter
public class SmoothieDto
{
    private final UUID id;
    private final String name;

    public SmoothieDto(Smoothie smoothie)
    {
        id = smoothie.getId();
        name = smoothie.getName();
    }
}
