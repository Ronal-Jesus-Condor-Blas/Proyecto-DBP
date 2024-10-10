package com.proyecto_dbp.proyecto_dbp.typefood.application;

import com.proyecto_dbp.proyecto_dbp.common.ApiPathConstants;
import com.proyecto_dbp.proyecto_dbp.typefood.dto.TypeFoodDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.TYPE_FOOD_ROUTE)
@SecurityRequirement(name = "Bearer Authentication")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface TypeFoodApi {

    @PostMapping
    ResponseEntity<TypeFoodDto> createTypeFood(@RequestBody TypeFoodDto typeFoodDto);

    @GetMapping("/{id}")
    ResponseEntity<TypeFoodDto> getTypeFoodById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<TypeFoodDto>> getAllTypeFoods();

    @PutMapping("/{id}")
    ResponseEntity<TypeFoodDto> updateTypeFood(@PathVariable Long id, @RequestBody TypeFoodDto typeFoodDto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteTypeFood(@PathVariable Long id);
}
