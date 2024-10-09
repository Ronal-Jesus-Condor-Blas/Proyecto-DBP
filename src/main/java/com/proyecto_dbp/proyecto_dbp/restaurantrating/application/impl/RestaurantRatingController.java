package com.proyecto_dbp.proyecto_dbp.restaurantrating.application.impl;

import com.proyecto_dbp.proyecto_dbp.restaurantrating.application.RestaurantRatingApi;
import com.proyecto_dbp.proyecto_dbp.restaurantrating.domain.services.RestaurantRatingService;
import com.proyecto_dbp.proyecto_dbp.restaurantrating.dto.RestaurantRatingCreateDto;
import com.proyecto_dbp.proyecto_dbp.restaurantrating.dto.RestaurantRatingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantRatingController implements RestaurantRatingApi {

    @Autowired
    private RestaurantRatingService restaurantRatingService;

    @Override
    public RestaurantRatingDto createRestaurantRating(RestaurantRatingCreateDto restaurantRatingCreateDto) {
        return restaurantRatingService.createRestaurantRating(restaurantRatingCreateDto);
    }

    @Override
    public RestaurantRatingDto getRestaurantRatingById(Long id) {
        return restaurantRatingService.getRestaurantRatingById(id);
    }

    @Override
    public List<RestaurantRatingDto> getAllRestaurantRatings() {
        return restaurantRatingService.getAllRestaurantRatings();
    }

    @Override
    public RestaurantRatingDto updateRestaurantRating(Long id, RestaurantRatingCreateDto restaurantRatingCreateDto) {
        return restaurantRatingService.updateRestaurantRating(id, restaurantRatingCreateDto);
    }

    @Override
    public void deleteRestaurantRating(Long id) {
        restaurantRatingService.deleteRestaurantRating(id);
    }
}