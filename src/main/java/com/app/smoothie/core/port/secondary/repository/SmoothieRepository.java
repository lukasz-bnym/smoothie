package com.app.smoothie.core.port.secondary.repository;

import com.app.smoothie.core.entity.Smoothie;
import java.util.List;
import java.util.UUID;

public interface SmoothieRepository {
    List<Smoothie> findAll();
    Smoothie findById(UUID id);
    Smoothie save(Smoothie smoothie);
    void delete(Smoothie smoothie);
}
