package com.proyecto_dbp.proyecto_dbp.restaurant.infrastructure;

import com.proyecto_dbp.proyecto_dbp.restaurant.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}