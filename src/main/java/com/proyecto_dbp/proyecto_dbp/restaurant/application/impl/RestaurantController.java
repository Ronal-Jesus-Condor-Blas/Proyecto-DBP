package com.proyecto_dbp.proyecto_dbp.restaurant.application.impl;

import com.proyecto_dbp.proyecto_dbp.restaurant.application.RestaurantApi;
import com.proyecto_dbp.proyecto_dbp.restaurant.domain.services.RestaurantService;
import com.proyecto_dbp.proyecto_dbp.restaurant.dto.RestaurantCreateDto;
import com.proyecto_dbp.proyecto_dbp.restaurant.dto.RestaurantDto;
import com.proyecto_dbp.proyecto_dbp.restaurant.dto.RestaurantUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController implements RestaurantApi {

    @Autowired
    private RestaurantService restaurantService;

    @Override
    public RestaurantDto createRestaurant(RestaurantCreateDto restaurantCreateDto) {
        return restaurantService.createRestaurant(restaurantCreateDto);
    }

    @Override
    public RestaurantDto getRestaurantById(Long id) {
        return restaurantService.getRestaurantById(id);
    }

    @Override
    public List<RestaurantDto> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @Override
    public RestaurantDto updateRestaurant(Long id, RestaurantUpdateDto restaurantUpdateDto) {
        return restaurantService.updateRestaurant(id, restaurantUpdateDto);
    }

    @Override
    public void deleteRestaurant(Long id) {
        restaurantService.deleteRestaurant(id);
    }
}