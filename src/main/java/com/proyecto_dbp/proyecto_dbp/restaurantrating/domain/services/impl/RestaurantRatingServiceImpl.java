package com.proyecto_dbp.proyecto_dbp.restaurantrating.domain.services.impl;

import com.proyecto_dbp.proyecto_dbp.restaurant.domain.Restaurant;
import com.proyecto_dbp.proyecto_dbp.restaurantrating.domain.RestaurantRating;
import com.proyecto_dbp.proyecto_dbp.restaurantrating.domain.services.RestaurantRatingService;
import com.proyecto_dbp.proyecto_dbp.restaurantrating.dto.RestaurantRatingCreateDto;
import com.proyecto_dbp.proyecto_dbp.restaurantrating.dto.RestaurantRatingDto;
import com.proyecto_dbp.proyecto_dbp.restaurantrating.infrastructure.RestaurantRatingRepository;
import com.proyecto_dbp.proyecto_dbp.user.domain.User;
import com.proyecto_dbp.proyecto_dbp.user.infrastructure.UserRepository;
import com.proyecto_dbp.proyecto_dbp.restaurant.infrastructure.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantRatingServiceImpl implements RestaurantRatingService {

    @Autowired
    private RestaurantRatingRepository restaurantRatingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public RestaurantRatingDto createRestaurantRating(RestaurantRatingCreateDto restaurantRatingCreateDto) {
        RestaurantRating restaurantRating = new RestaurantRating();
        restaurantRating.setRating(restaurantRatingCreateDto.getRating());
        restaurantRating.setComment(restaurantRatingCreateDto.getComment());
        restaurantRating.setRatingDate(LocalDateTime.now());
        restaurantRating.setUser(userRepository.findById(restaurantRatingCreateDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found")));
        restaurantRating.setRestaurant(restaurantRepository.findById(restaurantRatingCreateDto.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found")));
        RestaurantRating savedRestaurantRating = restaurantRatingRepository.save(restaurantRating);
        return mapToDto(savedRestaurantRating);
    }

    @Override
    public RestaurantRatingDto getRestaurantRatingById(Long id) {
        RestaurantRating restaurantRating = restaurantRatingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RestaurantRating not found"));
        return mapToDto(restaurantRating);
    }

    @Override
    public List<RestaurantRatingDto> getAllRestaurantRatings() {
        return restaurantRatingRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public RestaurantRatingDto updateRestaurantRating(Long id, RestaurantRatingCreateDto restaurantRatingCreateDto) {
        RestaurantRating restaurantRating = restaurantRatingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RestaurantRating not found"));
        restaurantRating.setRating(restaurantRatingCreateDto.getRating());
        restaurantRating.setComment(restaurantRatingCreateDto.getComment());
        restaurantRating.setUser(userRepository.findById(restaurantRatingCreateDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found")));
        restaurantRating.setRestaurant(restaurantRepository.findById(restaurantRatingCreateDto.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found")));
        RestaurantRating updatedRestaurantRating = restaurantRatingRepository.save(restaurantRating);
        return mapToDto(updatedRestaurantRating);
    }

    @Override
    public void deleteRestaurantRating(Long id) {
        RestaurantRating restaurantRating = restaurantRatingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RestaurantRating not found"));
        restaurantRatingRepository.delete(restaurantRating);
    }

    private RestaurantRatingDto mapToDto(RestaurantRating restaurantRating) {
        RestaurantRatingDto restaurantRatingDto = new RestaurantRatingDto();
        restaurantRatingDto.setRestaurantRatingId(restaurantRating.getRestaurantRatingId());
        restaurantRatingDto.setRating(restaurantRating.getRating());
        restaurantRatingDto.setRatingDate(restaurantRating.getRatingDate());
        restaurantRatingDto.setComment(restaurantRating.getComment());
        restaurantRatingDto.setUserId(restaurantRating.getUser().getUserId());
        restaurantRatingDto.setRestaurantId(restaurantRating.getRestaurant().getRestaurantId());
        return restaurantRatingDto;
    }
}