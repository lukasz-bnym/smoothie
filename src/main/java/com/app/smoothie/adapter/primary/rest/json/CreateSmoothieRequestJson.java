package com.app.smoothie.adapter.primary.rest.json;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CreateSmoothieRequestJson
{
    @NotBlank
    private String name;
}
