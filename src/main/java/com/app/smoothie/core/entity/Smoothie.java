package com.app.smoothie.core.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

@Data
public class Smoothie
{
    private final UUID id;
    private Long version;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    private final String name;
    private String description;
    private String ingredients;
    private int calories;
    private int proteins;
    private int fat;
    private int carbs;
}
