package com.app.smoothie.core.usecase;

import com.app.smoothie.core.port.primary.usecase.UpdateSmoothieUseCase;
import com.app.smoothie.core.entity.Smoothie;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SmoothieUpdater {
    private final Smoothie smoothie;

    static SmoothieUpdater update(Smoothie smoothie) {
        return new SmoothieUpdater(smoothie);
    }

    void with(UpdateSmoothieUseCase.UpdateSmoothieRequest request) {
        smoothie.setDescription(request.getDescription());
        smoothie.setFat(request.getFat());
        smoothie.setCalories(request.getCalories());
        smoothie.setCarbs(request.getCarbs());
        smoothie.setProteins(request.getProteins());
        smoothie.setIngredients(request.getIngredients());
    }
}
