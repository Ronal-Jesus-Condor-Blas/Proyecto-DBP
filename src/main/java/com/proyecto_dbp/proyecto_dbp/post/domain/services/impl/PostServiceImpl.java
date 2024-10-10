package com.proyecto_dbp.proyecto_dbp.post.domain.services.impl;

import com.proyecto_dbp.proyecto_dbp.comment.domain.Comment;
import com.proyecto_dbp.proyecto_dbp.exception.PostNotFoundException;
import com.proyecto_dbp.proyecto_dbp.exception.UserNotFoundException;
import com.proyecto_dbp.proyecto_dbp.post.domain.Post;
import com.proyecto_dbp.proyecto_dbp.post.domain.services.PostService;
import com.proyecto_dbp.proyecto_dbp.post.dto.PostCreateDto;
import com.proyecto_dbp.proyecto_dbp.post.dto.PostUpdateDto;
import com.proyecto_dbp.proyecto_dbp.post.infrastructure.PostRepository;
import com.proyecto_dbp.proyecto_dbp.user.domain.User;
import com.proyecto_dbp.proyecto_dbp.user.infrastructure.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Post getPost(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("Post not found"));
    }

    @Override
    public void updatePost(Long postId, PostUpdateDto postUpdateDto) {
        Post post = getPost(postId);
        post.setTitle(postUpdateDto.getTitle());
        post.setContent(postUpdateDto.getContent());
        postRepository.save(post);
    }

    @Override
    public void deletePost(Long postId) {
        Post post = getPost(postId);
        postRepository.delete(post);
    }

    @Override
    public void createPost(PostCreateDto postCreateDto) {
        Post post = new Post();
        post.setTitle(postCreateDto.getTitle());
        post.setContent(postCreateDto.getContent());
        postRepository.save(post);
    }

    @Override
    public void likePost(Long postId, Long userId) {
        Post post = getPost(postId);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        post.incrementLikes(user);
        postRepository.save(post);
    }

    @Override
    public void dislikePost(Long postId, Long userId) {
        Post post = getPost(postId);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        post.decrementLikes(user);
        postRepository.save(post);
    }

    @Override
    public void commentPost(Long postId, Comment comment) {
        Post post = getPost(postId);
        post.incrementComments(comment);
        postRepository.save(post);
    }
}
