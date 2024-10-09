package com.proyecto_dbp.proyecto_dbp.typefood.domain.services.impl;

import com.proyecto_dbp.proyecto_dbp.typefood.domain.TypeFood;
import com.proyecto_dbp.proyecto_dbp.typefood.domain.services.TypeFoodService;
import com.proyecto_dbp.proyecto_dbp.typefood.dto.TypeFoodDto;
import com.proyecto_dbp.proyecto_dbp.typefood.infrastructure.TypeFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeFoodServiceImpl implements TypeFoodService {

    @Autowired
    private TypeFoodRepository typeFoodRepository;

    @Override
    public TypeFoodDto createTypeFood(TypeFoodDto typeFoodDto) {
        TypeFood typeFood = new TypeFood();
        typeFood.setType(typeFoodDto.getType());
        TypeFood savedTypeFood = typeFoodRepository.save(typeFood);
        return mapToDto(savedTypeFood);
    }

    @Override
    public TypeFoodDto getTypeFoodById(Long id) {
        TypeFood typeFood = typeFoodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TypeFood not found"));
        return mapToDto(typeFood);
    }

    @Override
    public List<TypeFoodDto> getAllTypeFoods() {
        return typeFoodRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TypeFoodDto updateTypeFood(Long id, TypeFoodDto typeFoodDto) {
        TypeFood typeFood = typeFoodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TypeFood not found"));
        typeFood.setType(typeFoodDto.getType());
        TypeFood updatedTypeFood = typeFoodRepository.save(typeFood);
        return mapToDto(updatedTypeFood);
    }

    @Override
    public void deleteTypeFood(Long id) {
        TypeFood typeFood = typeFoodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TypeFood not found"));
        typeFoodRepository.delete(typeFood);
    }

    private TypeFoodDto mapToDto(TypeFood typeFood) {
        TypeFoodDto typeFoodDto = new TypeFoodDto();
        typeFoodDto.setTypeFoodId(typeFood.getTypeFoodId());
        typeFoodDto.setType(typeFood.getType());
        return typeFoodDto;
    }
}