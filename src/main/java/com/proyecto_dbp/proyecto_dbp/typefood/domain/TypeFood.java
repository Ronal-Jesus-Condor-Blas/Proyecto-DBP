package com.proyecto_dbp.proyecto_dbp.typefood.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
public class TypeFood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeFoodId;

    @NotNull
    @Size(max = 100)
    private String type; // Tipo de comida (e.g. italiana, mexicana, peruana)
    // Getters and Setters
}
