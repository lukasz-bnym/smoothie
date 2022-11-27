package com.app.smoothie.adapter.secondary.repository;

import com.app.smoothie.core.entity.Smoothie;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class SmoothieData
{
    @Id
    private UUID id;
    @Version
    private Long version;

    private String name;
    private String description;
    private String ingredients;
    private int calories;
    private int proteins;
    private int fat;
    private int carbs;

    public SmoothieData(Smoothie smoothie) {
        this.id = smoothie.getId();
        this.version = smoothie.getVersion();
        this.name = smoothie.getName();
        this.description = smoothie.getDescription();
        this.ingredients = smoothie.getIngredients();
        this.calories = smoothie.getCalories();
        this.proteins = smoothie.getProteins();
        this.fat = smoothie.getFat();
        this.carbs = smoothie.getCarbs();
    }

    Smoothie toSmoothie() {
        final Smoothie smoothie = new Smoothie(id, name);
        smoothie.setIngredients(ingredients);
        smoothie.setCarbs(carbs);
        smoothie.setFat(fat);
        smoothie.setProteins(proteins);
        smoothie.setCalories(calories);
        smoothie.setDescription(description);
        smoothie.setVersion(version);
        return smoothie;
    }
}
