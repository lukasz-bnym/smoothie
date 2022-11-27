package com.app.smoothie.adapter.primary.rest.json;

import com.app.smoothie.core.port.primary.usecase.dto.SmoothieWithDetailsDto;
import lombok.Getter;

@Getter
public class SmoothieWithDetailsJson extends SmoothieJson {

    private String description;
    private String ingredients;
    private int calories;
    private int carbs;
    private int fat;
    private int proteins;

    public SmoothieWithDetailsJson(SmoothieWithDetailsDto from)
    {
        super(from);
        description = from.getDescription();
        ingredients = from.getIngredients();
        calories = from.getCalories();
        carbs = from.getCarbs();
        fat = from.getFat();
        proteins = from.getProteins();
    }
}
