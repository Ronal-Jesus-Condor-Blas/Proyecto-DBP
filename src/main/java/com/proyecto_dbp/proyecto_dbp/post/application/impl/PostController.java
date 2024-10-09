package com.proyecto_dbp.proyecto_dbp.post.application.impl;

import com.proyecto_dbp.proyecto_dbp.comment.domain.Comment;
import com.proyecto_dbp.proyecto_dbp.post.application.PostApi;
import com.proyecto_dbp.proyecto_dbp.post.domain.Post;
import com.proyecto_dbp.proyecto_dbp.post.domain.services.PostService;
import com.proyecto_dbp.proyecto_dbp.post.dto.PostCreateDto;
import com.proyecto_dbp.proyecto_dbp.post.dto.PostUpdateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController implements PostApi {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @Override
    public ResponseEntity<Post> getPost(Long postId) {
        return ResponseEntity.ok(postService.getPost(postId));
    }

    @Override
    public ResponseEntity<Void> updatePost(Long postId, PostUpdateDto postUpdateDto) {
        postService.updatePost(postId, postUpdateDto);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deletePost(Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> createPost(PostCreateDto postCreateDto) {
        postService.createPost(postCreateDto);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> likePost(Long postId, Long userId) {
        postService.likePost(postId, userId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> dislikePost(Long postId, Long userId) {
        postService.dislikePost(postId, userId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> commentPost(Long postId, Comment comment) {
        postService.commentPost(postId, comment);
        return ResponseEntity.noContent().build();
    }
}