package com.proyecto_dbp.proyecto_dbp.comment.infrastructure;

import com.proyecto_dbp.proyecto_dbp.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
