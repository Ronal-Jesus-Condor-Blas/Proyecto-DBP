package com.proyecto_dbp.proyecto_dbp.post.infrastructure;

import com.proyecto_dbp.proyecto_dbp.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

}
