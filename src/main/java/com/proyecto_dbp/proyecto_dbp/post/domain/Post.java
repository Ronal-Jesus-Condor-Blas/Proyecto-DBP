package com.proyecto_dbp.proyecto_dbp.post.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Post {

    @Id
    private Long id;

    private String title;
    private String content;


}
