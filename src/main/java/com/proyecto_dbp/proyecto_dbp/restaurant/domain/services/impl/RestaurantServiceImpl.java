package com.proyecto_dbp.proyecto_dbp.restaurant.domain.services.impl;

import com.proyecto_dbp.proyecto_dbp.restaurant.domain.Restaurant;
import com.proyecto_dbp.proyecto_dbp.restaurant.domain.services.RestaurantService;
import com.proyecto_dbp.proyecto_dbp.restaurant.dto.RestaurantCreateDto;
import com.proyecto_dbp.proyecto_dbp.restaurant.dto.RestaurantDto;
import com.proyecto_dbp.proyecto_dbp.restaurant.dto.RestaurantUpdateDto;
import com.proyecto_dbp.proyecto_dbp.restaurant.infrastructure.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public RestaurantDto createRestaurant(RestaurantCreateDto restaurantCreateDto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantCreateDto.getName());
        restaurant.setLocation(restaurantCreateDto.getLocation());
        restaurant.setOpeningTime(restaurantCreateDto.getOpeningTime());
        restaurant.setClosingTime(restaurantCreateDto.getClosingTime());
        restaurant.setCreatedDate(LocalDateTime.now());
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return mapToDto(savedRestaurant);
    }

    @Override
    public RestaurantDto getRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        return mapToDto(restaurant);
    }

    @Override
    public List<RestaurantDto> getAllRestaurants() {
        return restaurantRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public RestaurantDto updateRestaurant(Long id, RestaurantUpdateDto restaurantUpdateDto) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        restaurant.setName(restaurantUpdateDto.getName());
        restaurant.setLocation(restaurantUpdateDto.getLocation());
        restaurant.setAverageRating(restaurantUpdateDto.getAverageRating());
        restaurant.setOpeningTime(restaurantUpdateDto.getOpeningTime());
        restaurant.setClosingTime(restaurantUpdateDto.getClosingTime());
        Restaurant updatedRestaurant = restaurantRepository.save(restaurant);
        return mapToDto(updatedRestaurant);
    }

    @Override
    public void deleteRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        restaurantRepository.delete(restaurant);
    }

    private RestaurantDto mapToDto(Restaurant restaurant) {
        RestaurantDto restaurantDto = new RestaurantDto();
        restaurantDto.setRestaurantId(restaurant.getRestaurantId());
        restaurantDto.setName(restaurant.getName());
        restaurantDto.setLocation(restaurant.getLocation());
        restaurantDto.setAverageRating(restaurant.getAverageRating());
        restaurantDto.setCreatedDate(restaurant.getCreatedDate());
        restaurantDto.setOpeningTime(restaurant.getOpeningTime());
        restaurantDto.setClosingTime(restaurant.getClosingTime());
        return restaurantDto;
    }
}