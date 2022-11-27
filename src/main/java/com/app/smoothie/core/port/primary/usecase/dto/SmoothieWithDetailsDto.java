package com.app.smoothie.core.port.primary.usecase.dto;

import com.app.smoothie.core.entity.Smoothie;
import lombok.Getter;

@Getter
public class SmoothieWithDetailsDto extends SmoothieDto {

    private String description;
    private String ingredients;
    private int calories;
    private int proteins;
    private int fat;
    private int carbs;

    public SmoothieWithDetailsDto(Smoothie smoothie)
    {
        super(smoothie);
        description = smoothie.getDescription();
        ingredients = smoothie.getIngredients();
        calories = smoothie.getCalories();
        proteins = smoothie.getProteins();
        fat = smoothie.getFat();
        carbs = smoothie.getCarbs();
    }
}
