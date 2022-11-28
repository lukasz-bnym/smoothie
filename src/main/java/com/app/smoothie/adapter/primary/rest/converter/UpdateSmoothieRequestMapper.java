package com.app.smoothie.adapter.primary.rest.converter;

import com.app.smoothie.adapter.primary.rest.json.UpdateSmoothieRequestJson;
import com.app.smoothie.core.port.primary.usecase.UpdateSmoothieUseCase;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UpdateSmoothieRequestMapper
{
    public static UpdateSmoothieUseCase.UpdateSmoothieRequest map(UpdateSmoothieRequestJson from, UUID id) {
        final UpdateSmoothieUseCase.UpdateSmoothieRequest to = new UpdateSmoothieUseCase.UpdateSmoothieRequest(id);
        to.setCalories(from.getCalories());
        to.setFat(from.getFat());
        to.setProteins(from.getProteins());
        to.setIngredients(from.getIngredients());
        to.setDescription(from.getDescription());
        to.setCarbs(from.getCarbs());
        return to;
    }
}
