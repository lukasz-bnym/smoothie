package com.app.smoothie.core.port.primary.usecase;

import com.app.smoothie.core.port.primary.usecase.dto.EntityRequest;
import com.app.smoothie.core.port.primary.usecase.dto.SmoothieWithDetailsDto;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

public interface UpdateSmoothieUseCase
{

    SmoothieWithDetailsDto execute(UpdateSmoothieRequest request);

    @Getter
    @Setter
    class UpdateSmoothieRequest extends EntityRequest {
        private String description;
        private String ingredients;
        private int calories;
        private int carbs;
        private int fat;
        private int proteins;

        public UpdateSmoothieRequest(UUID id)
        {
            super(id);
        }
    }
}
