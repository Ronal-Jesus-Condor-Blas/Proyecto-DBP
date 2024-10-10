package com.proyecto_dbp.proyecto_dbp.restaurant.application.impl;

import com.proyecto_dbp.proyecto_dbp.restaurant.application.RestaurantApi;
import com.proyecto_dbp.proyecto_dbp.restaurant.domain.services.RestaurantService;
import com.proyecto_dbp.proyecto_dbp.restaurant.dto.RestaurantCreateDto;
import com.proyecto_dbp.proyecto_dbp.restaurant.dto.RestaurantDto;
import com.proyecto_dbp.proyecto_dbp.restaurant.dto.RestaurantUpdateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController implements RestaurantApi {

    private final RestaurantService restaurantService;

    // Constructor con inyección de dependencias
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @Override
    public ResponseEntity<RestaurantDto> createRestaurant(RestaurantCreateDto restaurantCreateDto) {
        return ResponseEntity.ok(restaurantService.createRestaurant(restaurantCreateDto));
    }

    @Override
    public ResponseEntity<RestaurantDto> getRestaurantById(Long id) {
        return ResponseEntity.ok(restaurantService.getRestaurantById(id));
    }

    @Override
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants() {
        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }

    @Override
    public ResponseEntity<RestaurantDto> updateRestaurant(Long id, RestaurantUpdateDto restaurantUpdateDto) {
        return ResponseEntity.ok(restaurantService.updateRestaurant(id, restaurantUpdateDto));
    }

    @Override
    public ResponseEntity<Void> deleteRestaurant(Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();  // Retorna un código 204
    }
}
