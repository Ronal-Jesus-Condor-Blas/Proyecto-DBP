package com.proyecto_dbp.proyecto_dbp.restaurant.application;

import com.proyecto_dbp.proyecto_dbp.common.ApiPathConstants;
import com.proyecto_dbp.proyecto_dbp.restaurant.dto.RestaurantCreateDto;
import com.proyecto_dbp.proyecto_dbp.restaurant.dto.RestaurantDto;
import com.proyecto_dbp.proyecto_dbp.restaurant.dto.RestaurantUpdateDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.RESTAURANT_ROUTE)
@SecurityRequirement(name = "Bearer Authentication")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface RestaurantApi {

    @PostMapping
    ResponseEntity<RestaurantDto> createRestaurant(@RequestBody RestaurantCreateDto restaurantCreateDto);

    @GetMapping("/{id}")
    ResponseEntity<RestaurantDto> getRestaurantById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<RestaurantDto>> getAllRestaurants();

    @PutMapping("/{id}")
    ResponseEntity<RestaurantDto> updateRestaurant(@PathVariable Long id, @RequestBody RestaurantUpdateDto restaurantUpdateDto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteRestaurant(@PathVariable Long id);
}
