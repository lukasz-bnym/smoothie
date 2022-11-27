package com.app.smoothie.adapter.secondary.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmoothieStorage extends JpaRepository<SmoothieData, UUID>
{
}
