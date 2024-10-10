package com.proyecto_dbp.proyecto_dbp.restaurantrating.domain.services.impl;

import com.proyecto_dbp.proyecto_dbp.exception.EntityNotFoundException;
import com.proyecto_dbp.proyecto_dbp.restaurantrating.domain.RestaurantRating;
import com.proyecto_dbp.proyecto_dbp.restaurantrating.domain.services.RestaurantRatingService;
import com.proyecto_dbp.proyecto_dbp.restaurantrating.dto.RestaurantRatingCreateDto;
import com.proyecto_dbp.proyecto_dbp.restaurantrating.dto.RestaurantRatingDto;
import com.proyecto_dbp.proyecto_dbp.restaurantrating.infrastructure.RestaurantRatingRepository;
import com.proyecto_dbp.proyecto_dbp.user.infrastructure.UserRepository;
import com.proyecto_dbp.proyecto_dbp.restaurant.infrastructure.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantRatingServiceImpl implements RestaurantRatingService {

    private final RestaurantRatingRepository restaurantRatingRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    // Inyección de dependencias mediante constructor
    public RestaurantRatingServiceImpl(RestaurantRatingRepository restaurantRatingRepository,
                                       UserRepository userRepository,
                                       RestaurantRepository restaurantRepository) {
        this.restaurantRatingRepository = restaurantRatingRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public RestaurantRatingDto createRestaurantRating(RestaurantRatingCreateDto restaurantRatingCreateDto) {
        RestaurantRating restaurantRating = mapToEntity(restaurantRatingCreateDto);
        RestaurantRating savedRestaurantRating = restaurantRatingRepository.save(restaurantRating);
        return mapToDto(savedRestaurantRating);
    }

    @Override
    public RestaurantRatingDto getRestaurantRatingById(Long id) {
        RestaurantRating restaurantRating = restaurantRatingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("RestaurantRating not found"));
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
                .orElseThrow(() -> new EntityNotFoundException("RestaurantRating not found"));
        updateFields(restaurantRating, restaurantRatingCreateDto);
        RestaurantRating updatedRestaurantRating = restaurantRatingRepository.save(restaurantRating);
        return mapToDto(updatedRestaurantRating);
    }

    @Override
    public void deleteRestaurantRating(Long id) {
        RestaurantRating restaurantRating = restaurantRatingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("RestaurantRating not found"));
        restaurantRatingRepository.delete(restaurantRating);
    }

    // Mapeo de DTO a entidad
    private RestaurantRating mapToEntity(RestaurantRatingCreateDto dto) {
        return RestaurantRating.builder()
                .rating(dto.getRating())
                .comment(dto.getComment())
                .ratingDate(LocalDateTime.now())
                .user(userRepository.findById(dto.getUserId())
                        .orElseThrow(() -> new EntityNotFoundException("User not found")))
                .restaurant(restaurantRepository.findById(dto.getRestaurantId())
                        .orElseThrow(() -> new EntityNotFoundException("Restaurant not found")))
                .build();
    }

    // Mapeo de entidad a DTO
    private RestaurantRatingDto mapToDto(RestaurantRating restaurantRating) {
        return RestaurantRatingDto.builder()
                .restaurantRatingId(restaurantRating.getRestaurantRatingId())
                .rating(restaurantRating.getRating())
                .comment(restaurantRating.getComment())
                .ratingDate(restaurantRating.getRatingDate())
                .userId(restaurantRating.getUser().getUserId())
                .restaurantId(restaurantRating.getRestaurant().getRestaurantId())
                .build();
    }

    // Actualización de campos
    private void updateFields(RestaurantRating restaurantRating, RestaurantRatingCreateDto dto) {
        restaurantRating.setRating(dto.getRating());
        restaurantRating.setComment(dto.getComment());
        restaurantRating.setUser(userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found")));
        restaurantRating.setRestaurant(restaurantRepository.findById(dto.getRestaurantId())
                .orElseThrow(() -> new EntityNotFoundException("Restaurant not found")));
    }
}
