package com.proyecto_dbp.proyecto_dbp.restaurantrating.application.impl;

import com.proyecto_dbp.proyecto_dbp.restaurantrating.domain.services.RestaurantRatingService;
import com.proyecto_dbp.proyecto_dbp.restaurantrating.dto.RestaurantRatingCreateDto;
import com.proyecto_dbp.proyecto_dbp.restaurantrating.dto.RestaurantRatingDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class RestaurantRatingControllerTest {

    @Mock
    private RestaurantRatingService restaurantRatingService;

    @InjectMocks
    private RestaurantRatingController restaurantRatingController;

    private static final Long RATING_ID = 1L;

    private static final RestaurantRatingDto RATING_DTO = RestaurantRatingDto.builder()
            .restaurantRatingId(RATING_ID)
            .rating(4)
            .comment("Great restaurant")
            .ratingDate(LocalDateTime.now())
            .userId(1L)
            .restaurantId(1L)
            .build();

    private static final RestaurantRatingCreateDto RATING_CREATE_DTO = RestaurantRatingCreateDto.builder()
            .rating(4)
            .comment("Great restaurant")
            .userId(1L)
            .restaurantId(1L)
            .build();

    @Test
    void it_should_return_non_null_when_create_restaurant_rating() {
        Mockito.when(restaurantRatingService.createRestaurantRating(RATING_CREATE_DTO))
                .thenReturn(RATING_DTO);

        assertThat(restaurantRatingController.createRestaurantRating(RATING_CREATE_DTO)).isNotNull();
    }

    @Test
    void it_should_return_expected_rating_when_create_restaurant_rating() {
        Mockito.when(restaurantRatingService.createRestaurantRating(RATING_CREATE_DTO))
                .thenReturn(RATING_DTO);

        assertThat(restaurantRatingController.createRestaurantRating(RATING_CREATE_DTO).getBody())
                .isEqualTo(RATING_DTO);
    }

    @Test
    void it_should_return_200_when_create_restaurant_rating() {
        Mockito.when(restaurantRatingService.createRestaurantRating(RATING_CREATE_DTO))
                .thenReturn(RATING_DTO);

        assertThat(restaurantRatingController.createRestaurantRating(RATING_CREATE_DTO).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    void it_should_return_200_when_get_rating_by_id() {
        Mockito.when(restaurantRatingService.getRestaurantRatingById(RATING_ID))
                .thenReturn(RATING_DTO);

        assertThat(restaurantRatingController.getRestaurantRatingById(RATING_ID).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    void it_should_return_no_content_when_delete_rating() {
        Mockito.doNothing().when(restaurantRatingService).deleteRestaurantRating(RATING_ID);

        assertThat(restaurantRatingController.deleteRestaurantRating(RATING_ID).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(204));
    }
}
