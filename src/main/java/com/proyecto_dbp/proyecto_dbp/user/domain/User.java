package com.proyecto_dbp.proyecto_dbp.user.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class User {

    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
    private String status;



}
