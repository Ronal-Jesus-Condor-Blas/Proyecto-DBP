package com.proyecto_dbp.proyecto_dbp.foodrating.infrastructure;

import com.proyecto_dbp.proyecto_dbp.foodrating.domain.FoodRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRatingRepository extends JpaRepository<FoodRating, Long> {
}