package com.proyecto_dbp.proyecto_dbp.post.application.impl;


import com.proyecto_dbp.proyecto_dbp.post.application.PostApi;
import com.proyecto_dbp.proyecto_dbp.post.domain.Post;
import com.proyecto_dbp.proyecto_dbp.post.domain.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController implements PostApi {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;}

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



}
