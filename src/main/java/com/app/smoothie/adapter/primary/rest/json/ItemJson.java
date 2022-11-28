package com.app.smoothie.adapter.primary.rest.json;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemJson
{
    @NotNull
    private UUID id;
    @Positive
    private int quantity;
}
