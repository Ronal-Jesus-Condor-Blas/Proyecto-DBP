package com.proyecto_dbp.proyecto_dbp.post.domain.services.impl;


import com.proyecto_dbp.proyecto_dbp.post.domain.Post;
import com.proyecto_dbp.proyecto_dbp.post.domain.services.PostService;
import com.proyecto_dbp.proyecto_dbp.post.infrastructure.PostRepository;
import jakarta.validation.OverridesAttribute;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post getPost(Long postId) {
        return Optional.of(postId)
                .flatMap(postRepository::findById)
                .orElseThrow(() -> new RuntimeException("Post not found"));
    }

    @Override
    public void updatePost(Long postId, PostUpdateDto postUpdateDto) {
        Optional.of(postId)
                .map(this::getPostByPostId)
                .map(existPost -> updateFieldsPost(existPost, postUpdateDto))
                .map(postRepository::save)
                .orElseThrow(() -> new RuntimeException("Error couldn't update post"));
    }

    @Override
    public void deletePost(Long postId) {
        Optional.of(postId)
                .map(this::getPostByPostId)
                .ifPresent(postRepository::delete);
    }

    @Override
    public void createPost(PostCreateDto postCreateDto) {
        postRepository.save(Post.builder()
                .title(postCreateDto.getTitle())
                .content(postCreateDto.getContent())
                .build());
    }

    private Post getPostByPostId(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
    }

    private Post updateFieldsPost(Post existPost, PostUpdateDto postUpdateDto) {
        existPost.setTitle(postUpdateDto.getTitle());
        existPost.setContent(postUpdateDto.getContent());
        return existPost;
    }
}
