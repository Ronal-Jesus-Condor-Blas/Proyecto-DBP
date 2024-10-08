package com.proyecto_dbp.proyecto_dbp.post.domain.services;

import com.proyecto_dbp.proyecto_dbp.post.domain.Post;

public interface PostService {

    Post getPost(Long postId);
    void updatePost(Long postId, PostUpdateDto postUpdateDto);
    void deletePost(Long postId);
    void createPost(PostCreateDto postCreateDto);
    void likePost(Long postId);
    void dislikePost(Long postId);

}
