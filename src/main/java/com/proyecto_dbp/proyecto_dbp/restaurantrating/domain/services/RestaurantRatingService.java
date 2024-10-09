package com.proyecto_dbp.proyecto_dbp.restaurantrating.domain.services;

import com.proyecto_dbp.proyecto_dbp.restaurantrating.dto.RestaurantRatingCreateDto;
import com.proyecto_dbp.proyecto_dbp.restaurantrating.dto.RestaurantRatingDto;

import java.util.List;

public interface RestaurantRatingService {
    RestaurantRatingDto createRestaurantRating(RestaurantRatingCreateDto restaurantRatingCreateDto);
    RestaurantRatingDto getRestaurantRatingById(Long id);
    List<RestaurantRatingDto> getAllRestaurantRatings();
    RestaurantRatingDto updateRestaurantRating(Long id, RestaurantRatingCreateDto restaurantRatingCreateDto);
    void deleteRestaurantRating(Long id);
}