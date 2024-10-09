package com.proyecto_dbp.proyecto_dbp.restaurant.application;

import com.proyecto_dbp.proyecto_dbp.common.ApiPathConstants;
import com.proyecto_dbp.proyecto_dbp.restaurant.dto.RestaurantCreateDto;
import com.proyecto_dbp.proyecto_dbp.restaurant.dto.RestaurantDto;
import com.proyecto_dbp.proyecto_dbp.restaurant.dto.RestaurantUpdateDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.RESTAURANT_ROUTE)
@SecurityRequirement(name = "Bearer Authentication")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface RestaurantApi {

    @PostMapping
    RestaurantDto createRestaurant(@RequestBody RestaurantCreateDto restaurantCreateDto);

    @GetMapping("/{id}")
    RestaurantDto getRestaurantById(@PathVariable Long id);

    @GetMapping
    List<RestaurantDto> getAllRestaurants();

    @PutMapping("/{id}")
    RestaurantDto updateRestaurant(@PathVariable Long id, @RequestBody RestaurantUpdateDto restaurantUpdateDto);

    @DeleteMapping("/{id}")
    void deleteRestaurant(@PathVariable Long id);
}