package com.proyecto_dbp.proyecto_dbp.typefood.application.impl;

import com.proyecto_dbp.proyecto_dbp.typefood.application.TypeFoodApi;
import com.proyecto_dbp.proyecto_dbp.typefood.domain.services.TypeFoodService;
import com.proyecto_dbp.proyecto_dbp.typefood.dto.TypeFoodDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeFoodController implements TypeFoodApi {

    private final TypeFoodService typeFoodService;

    // Constructor-based injection (best practice)
    public TypeFoodController(TypeFoodService typeFoodService) {
        this.typeFoodService = typeFoodService;
    }

    @Override
    public ResponseEntity<TypeFoodDto> createTypeFood(TypeFoodDto typeFoodDto) {
        return ResponseEntity.ok(typeFoodService.createTypeFood(typeFoodDto));
    }

    @Override
    public ResponseEntity<TypeFoodDto> getTypeFoodById(Long id) {
        return ResponseEntity.ok(typeFoodService.getTypeFoodById(id));
    }

    @Override
    public ResponseEntity<List<TypeFoodDto>> getAllTypeFoods() {
        return ResponseEntity.ok(typeFoodService.getAllTypeFoods());
    }

    @Override
    public ResponseEntity<TypeFoodDto> updateTypeFood(Long id, TypeFoodDto typeFoodDto) {
        return ResponseEntity.ok(typeFoodService.updateTypeFood(id, typeFoodDto));
    }

    @Override
    public ResponseEntity<Void> deleteTypeFood(Long id) {
        typeFoodService.deleteTypeFood(id);
        return ResponseEntity.noContent().build();  // Return 204 No Content after deletion
    }
}
