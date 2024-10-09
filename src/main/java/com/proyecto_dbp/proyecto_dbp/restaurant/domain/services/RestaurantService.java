package com.proyecto_dbp.proyecto_dbp.restaurant.domain.services;

import com.proyecto_dbp.proyecto_dbp.restaurant.dto.RestaurantCreateDto;
import com.proyecto_dbp.proyecto_dbp.restaurant.dto.RestaurantDto;
import com.proyecto_dbp.proyecto_dbp.restaurant.dto.RestaurantUpdateDto;

import java.util.List;

public interface RestaurantService {
    RestaurantDto createRestaurant(RestaurantCreateDto restaurantCreateDto);
    RestaurantDto getRestaurantById(Long id);
    List<RestaurantDto> getAllRestaurants();
    RestaurantDto updateRestaurant(Long id, RestaurantUpdateDto restaurantUpdateDto);
    void deleteRestaurant(Long id);
}