package com.app.smoothie.adapter.primary.rest.json;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSmoothieRequestJson
{
    @NotBlank
    private String description;
    @NotBlank
    private String ingredients;
    @Positive
    private int calories;
    @Positive
    private int carbs;
    @Positive
    private int fat;
    @Positive
    private int proteins;
}
