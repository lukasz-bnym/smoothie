package com.app.smoothie.adapter.primary.rest.json;

import com.app.smoothie.core.port.primary.usecase.dto.SmoothieDto;
import java.util.UUID;
import lombok.Getter;

@Getter
public class SmoothieJson
{
    private final UUID id;
    private final String name;

    public SmoothieJson(SmoothieDto response) {
        id = response.getId();
        name = response.getName();
    }
}
