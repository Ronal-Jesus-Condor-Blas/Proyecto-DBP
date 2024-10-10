package com.proyecto_dbp.proyecto_dbp.restaurantrating.application.impl;

import com.proyecto_dbp.proyecto_dbp.restaurantrating.application.RestaurantRatingApi;
import com.proyecto_dbp.proyecto_dbp.restaurantrating.domain.services.RestaurantRatingService;
import com.proyecto_dbp.proyecto_dbp.restaurantrating.dto.RestaurantRatingCreateDto;
import com.proyecto_dbp.proyecto_dbp.restaurantrating.dto.RestaurantRatingDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantRatingController implements RestaurantRatingApi {

    private final RestaurantRatingService restaurantRatingService;

    // Constructor con inyección de dependencias
    public RestaurantRatingController(RestaurantRatingService restaurantRatingService) {
        this.restaurantRatingService = restaurantRatingService;
    }

    @Override
    public ResponseEntity<RestaurantRatingDto> createRestaurantRating(RestaurantRatingCreateDto restaurantRatingCreateDto) {
        return ResponseEntity.ok(restaurantRatingService.createRestaurantRating(restaurantRatingCreateDto));
    }

    @Override
    public ResponseEntity<RestaurantRatingDto> getRestaurantRatingById(Long id) {
        return ResponseEntity.ok(restaurantRatingService.getRestaurantRatingById(id));
    }

    @Override
    public ResponseEntity<List<RestaurantRatingDto>> getAllRestaurantRatings() {
        return ResponseEntity.ok(restaurantRatingService.getAllRestaurantRatings());
    }

    @Override
    public ResponseEntity<RestaurantRatingDto> updateRestaurantRating(Long id, RestaurantRatingCreateDto restaurantRatingCreateDto) {
        return ResponseEntity.ok(restaurantRatingService.updateRestaurantRating(id, restaurantRatingCreateDto));
    }

    @Override
    public ResponseEntity<Void> deleteRestaurantRating(Long id) {
        restaurantRatingService.deleteRestaurantRating(id);
        return ResponseEntity.noContent().build();  // Retorna 204 No Content
    }
}
