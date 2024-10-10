package com.proyecto_dbp.proyecto_dbp.restaurantrating.infrastructure;

import com.proyecto_dbp.proyecto_dbp.restaurantrating.domain.RestaurantRating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRatingRepository extends JpaRepository<RestaurantRating, Long> {
}
