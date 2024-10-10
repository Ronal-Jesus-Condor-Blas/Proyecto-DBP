package com.proyecto_dbp.proyecto_dbp.post.domain.services;

import com.proyecto_dbp.proyecto_dbp.comment.domain.Comment;
import com.proyecto_dbp.proyecto_dbp.post.domain.Post;
import com.proyecto_dbp.proyecto_dbp.post.dto.PostCreateDto;
import com.proyecto_dbp.proyecto_dbp.post.dto.PostUpdateDto;

public interface PostService {

    Post getPost(Long postId);
    void updatePost(Long postId, PostUpdateDto postUpdateDto);
    void deletePost(Long postId);
    void createPost(PostCreateDto postCreateDto);
    void likePost(Long postId, Long userId);
    void dislikePost(Long postId, Long userId);
    void commentPost(Long postId, Comment comment);
}
