package com.app.smoothie.core.port.primary.usecase.dto;

import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class EntityRequest
{
    private final UUID id;
}
