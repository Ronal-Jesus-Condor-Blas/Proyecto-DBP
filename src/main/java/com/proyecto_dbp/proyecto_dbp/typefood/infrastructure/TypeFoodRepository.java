package com.proyecto_dbp.proyecto_dbp.typefood.infrastructure;

import com.proyecto_dbp.proyecto_dbp.typefood.domain.TypeFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeFoodRepository extends JpaRepository<TypeFood, Long> {
}
