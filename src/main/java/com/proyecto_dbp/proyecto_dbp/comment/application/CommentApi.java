package com.proyecto_dbp.proyecto_dbp.comment.application;

import com.proyecto_dbp.proyecto_dbp.comment.domain.Comment;
import com.proyecto_dbp.proyecto_dbp.comment.dto.CommentRequestDto;
import com.proyecto_dbp.proyecto_dbp.comment.dto.CommentResponseDto;
import com.proyecto_dbp.proyecto_dbp.comment.dto.CommentUpdateDto;
import com.proyecto_dbp.proyecto_dbp.common.ApiPathConstants;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.COMMENT_ROUTE)
@SecurityRequirement(name = "Bearer Authentication")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public interface CommentApi {
    @PostMapping
    ResponseEntity<Comment> postComment(
            @RequestAttribute("X-User-Id") Long userId,
            @Valid @RequestBody CommentRequestDto commentRequestDto
    );

    @GetMapping("/{commentId}")
    ResponseEntity<CommentResponseDto> getComment(
            @RequestAttribute("X-User-Id") Long userId,
            @PathVariable("commentId") Long commentId
    );

    @PutMapping("/{commentId}")
    ResponseEntity<Void> updateComment(
            @RequestAttribute("X-User-Id") Long userId,
            @PathVariable("commentId") Long commentId,
            @Valid @RequestBody CommentUpdateDto commentUpdateDto
            );

    @DeleteMapping("/{commentId}")
    ResponseEntity<Void> deleteComment(
            @RequestAttribute("X-User-Id") Long userId,
            @PathVariable("commentId") Long commentId
    );
}
