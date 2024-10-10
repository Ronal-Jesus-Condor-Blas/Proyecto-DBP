package com.proyecto_dbp.proyecto_dbp.post.application;

import com.proyecto_dbp.proyecto_dbp.comment.domain.Comment;
import com.proyecto_dbp.proyecto_dbp.common.ApiPathConstants;
import com.proyecto_dbp.proyecto_dbp.post.domain.Post;
import com.proyecto_dbp.proyecto_dbp.post.dto.PostCreateDto;
import com.proyecto_dbp.proyecto_dbp.post.dto.PostUpdateDto;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.POST_ROUTE)
@SecurityRequirement(name = "Bearer Authentication")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface PostApi {

    @GetMapping
    ResponseEntity<Post> getPost(
            @RequestAttribute("X-Post-Id") Long postId
    );

    @PutMapping
    ResponseEntity<Void> updatePost(
            @RequestAttribute("X-Post-Id") Long postId,
            @Valid @RequestBody PostUpdateDto postUpdateDto
    );

    @DeleteMapping
    ResponseEntity<Void> deletePost(
            @RequestAttribute("X-Post-Id") Long postId
    );

    @PostMapping
    ResponseEntity<Void> createPost(
            @Valid @RequestBody PostCreateDto postCreateDto
    );

    @PutMapping("/like")
    ResponseEntity<Void> likePost(
            @RequestAttribute("X-Post-Id") Long postId,
            @RequestAttribute("X-User-Id") Long userId
    );

    @PutMapping("/dislike")
    ResponseEntity<Void> dislikePost(
            @RequestAttribute("X-Post-Id") Long postId,
            @RequestAttribute("X-User-Id") Long userId
    );

    @PutMapping("/comment")
    ResponseEntity<Void> commentPost(Long postId, Comment comment);
}
