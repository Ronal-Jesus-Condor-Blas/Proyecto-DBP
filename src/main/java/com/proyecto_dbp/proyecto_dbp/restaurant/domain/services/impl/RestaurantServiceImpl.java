package com.proyecto_dbp.proyecto_dbp.restaurant.domain.services.impl;

import com.proyecto_dbp.proyecto_dbp.exception.EntityNotFoundException;
import com.proyecto_dbp.proyecto_dbp.restaurant.domain.Restaurant;
import com.proyecto_dbp.proyecto_dbp.restaurant.domain.services.RestaurantService;
import com.proyecto_dbp.proyecto_dbp.restaurant.dto.RestaurantCreateDto;
import com.proyecto_dbp.proyecto_dbp.restaurant.dto.RestaurantDto;
import com.proyecto_dbp.proyecto_dbp.restaurant.dto.RestaurantUpdateDto;
import com.proyecto_dbp.proyecto_dbp.restaurant.infrastructure.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    // Inyección de dependencias mediante constructor
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public RestaurantDto createRestaurant(RestaurantCreateDto restaurantCreateDto) {
        Restaurant restaurant = mapToEntity(restaurantCreateDto);
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return mapToDto(savedRestaurant);
    }

    @Override
    public RestaurantDto getRestaurantById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant not found"));
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
                .orElseThrow(() -> new EntityNotFoundException("Restaurant not found"));
        updateFields(restaurant, restaurantUpdateDto);
        Restaurant updatedRestaurant = restaurantRepository.save(restaurant);
        return mapToDto(updatedRestaurant);
    }

    @Override
    public void deleteRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Restaurant not found"));
        restaurantRepository.delete(restaurant);
    }

    // Mapeo de entidad a DTO
    private RestaurantDto mapToDto(Restaurant restaurant) {
        return RestaurantDto.builder()
                .restaurantId(restaurant.getRestaurantId())
                .name(restaurant.getName())
                .location(restaurant.getLocation())
                .averageRating(restaurant.getAverageRating())
                .createdDate(restaurant.getCreatedDate())
                .openingTime(restaurant.getOpeningTime())
                .closingTime(restaurant.getClosingTime())
                .build();
    }

    // Mapeo de DTO a entidad
    private Restaurant mapToEntity(RestaurantCreateDto restaurantCreateDto) {
        return Restaurant.builder()
                .name(restaurantCreateDto.getName())
                .location(restaurantCreateDto.getLocation())
                .openingTime(restaurantCreateDto.getOpeningTime())
                .closingTime(restaurantCreateDto.getClosingTime())
                .createdDate(LocalDateTime.now())
                .build();
    }

    // Actualización de campos
    private void updateFields(Restaurant restaurant, RestaurantUpdateDto restaurantUpdateDto) {
        restaurant.setName(restaurantUpdateDto.getName());
        restaurant.setLocation(restaurantUpdateDto.getLocation());
        restaurant.setAverageRating(restaurantUpdateDto.getAverageRating());
        restaurant.setOpeningTime(restaurantUpdateDto.getOpeningTime());
        restaurant.setClosingTime(restaurantUpdateDto.getClosingTime());
    }
}
