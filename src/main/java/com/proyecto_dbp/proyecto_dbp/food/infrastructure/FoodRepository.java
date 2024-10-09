package com.proyecto_dbp.proyecto_dbp.food.infrastructure;

import com.proyecto_dbp.proyecto_dbp.food.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}