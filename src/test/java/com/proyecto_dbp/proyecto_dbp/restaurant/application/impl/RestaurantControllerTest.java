package com.proyecto_dbp.proyecto_dbp.restaurant.application.impl;

import com.proyecto_dbp.proyecto_dbp.restaurant.domain.services.RestaurantService;
import com.proyecto_dbp.proyecto_dbp.restaurant.dto.RestaurantCreateDto;
import com.proyecto_dbp.proyecto_dbp.restaurant.dto.RestaurantDto;
import com.proyecto_dbp.proyecto_dbp.restaurant.dto.RestaurantUpdateDto;
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
class RestaurantControllerTest {

    @Mock
    private RestaurantService restaurantService;

    @InjectMocks
    private RestaurantController restaurantController;

    private static final Long RESTAURANT_ID = 1L;

    private static final RestaurantDto RESTAURANT_DTO = RestaurantDto.builder()
            .restaurantId(RESTAURANT_ID)
            .name("Test Restaurant")
            .location("Test Location")
            .createdDate(LocalDateTime.now())
            .averageRating(4.5)
            .build();

    private static final RestaurantCreateDto RESTAURANT_CREATE_DTO = RestaurantCreateDto.builder()
            .name("Test Restaurant")
            .location("Test Location")
            .build();

    private static final RestaurantUpdateDto RESTAURANT_UPDATE_DTO = RestaurantUpdateDto.builder()
            .name("Updated Restaurant")
            .location("Updated Location")
            .averageRating(4.8)
            .build();

    @Test
    void it_should_return_non_null_when_create_restaurant() {
        Mockito.when(restaurantService.createRestaurant(RESTAURANT_CREATE_DTO))
                .thenReturn(RESTAURANT_DTO);

        assertThat(restaurantController.createRestaurant(RESTAURANT_CREATE_DTO)).isNotNull();
    }

    @Test
    void it_should_return_expected_restaurant_when_create_restaurant() {
        Mockito.when(restaurantService.createRestaurant(RESTAURANT_CREATE_DTO))
                .thenReturn(RESTAURANT_DTO);

        assertThat(restaurantController.createRestaurant(RESTAURANT_CREATE_DTO).getBody())
                .isEqualTo(RESTAURANT_DTO);
    }

    @Test
    void it_should_return_200_when_create_restaurant() {
        Mockito.when(restaurantService.createRestaurant(RESTAURANT_CREATE_DTO))
                .thenReturn(RESTAURANT_DTO);

        assertThat(restaurantController.createRestaurant(RESTAURANT_CREATE_DTO).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    void it_should_return_non_null_when_get_restaurant_by_id() {
        Mockito.when(restaurantService.getRestaurantById(RESTAURANT_ID))
                .thenReturn(RESTAURANT_DTO);

        assertThat(restaurantController.getRestaurantById(RESTAURANT_ID)).isNotNull();
    }

    @Test
    void it_should_return_expected_restaurant_when_get_restaurant_by_id() {
        Mockito.when(restaurantService.getRestaurantById(RESTAURANT_ID))
                .thenReturn(RESTAURANT_DTO);

        assertThat(restaurantController.getRestaurantById(RESTAURANT_ID).getBody())
                .isEqualTo(RESTAURANT_DTO);
    }

    @Test
    void it_should_return_200_when_get_restaurant_by_id() {
        Mockito.when(restaurantService.getRestaurantById(RESTAURANT_ID))
                .thenReturn(RESTAURANT_DTO);

        assertThat(restaurantController.getRestaurantById(RESTAURANT_ID).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    void it_should_return_no_content_when_delete_restaurant() {
        Mockito.doNothing().when(restaurantService).deleteRestaurant(RESTAURANT_ID);

        assertThat(restaurantController.deleteRestaurant(RESTAURANT_ID).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(204));
    }

    @Test
    void it_should_return_updated_restaurant_when_update_restaurant() {
        Mockito.when(restaurantService.updateRestaurant(RESTAURANT_ID, RESTAURANT_UPDATE_DTO))
                .thenReturn(RESTAURANT_DTO);

        assertThat(restaurantController.updateRestaurant(RESTAURANT_ID, RESTAURANT_UPDATE_DTO).getBody())
                .isEqualTo(RESTAURANT_DTO);
    }

    @Test
    void it_should_return_200_when_update_restaurant() {
        Mockito.when(restaurantService.updateRestaurant(RESTAURANT_ID, RESTAURANT_UPDATE_DTO))
                .thenReturn(RESTAURANT_DTO);

        assertThat(restaurantController.updateRestaurant(RESTAURANT_ID, RESTAURANT_UPDATE_DTO).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(200));
    }
}
