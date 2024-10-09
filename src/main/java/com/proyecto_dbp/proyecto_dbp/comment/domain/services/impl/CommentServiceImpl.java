package com.proyecto_dbp.proyecto_dbp.comment.domain.services.impl;

import com.proyecto_dbp.proyecto_dbp.comment.domain.Comment;
import com.proyecto_dbp.proyecto_dbp.comment.domain.services.CommentService;
import com.proyecto_dbp.proyecto_dbp.comment.dto.CommentRequestDto;
import com.proyecto_dbp.proyecto_dbp.comment.dto.CommentResponseDto;
import com.proyecto_dbp.proyecto_dbp.comment.dto.CommentUpdateDto;
import com.proyecto_dbp.proyecto_dbp.comment.infrastructure.CommentRepository;
import com.proyecto_dbp.proyecto_dbp.user.domain.User;
import com.proyecto_dbp.proyecto_dbp.user.infrastructure.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    public CommentServiceImpl(CommentRepository commentRepository, UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Comment postComment(Long userId, CommentRequestDto commentRequestDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Comment comment = mapToEntity(user, commentRequestDto);
        return commentRepository.save(comment);
    }

    private Comment mapToEntity(User user, CommentRequestDto commentRequest) {
        return Comment.builder()
                .user(user)
                .post(commentRequest.getPost())
                .content(commentRequest.getContent())
                .commentDate(LocalDateTime.now())
                .build();
    }

    @Override
    public CommentResponseDto getComment(Long userId, Long commentId) {
        return commentRepository.findById(commentId)
                .filter(comment -> comment.getUser().getUserId().equals(userId))
                .map(this::mapToResponseDto)
                .orElseThrow(() -> new RuntimeException("Comment not found or does not belong to the user"));
    }

    private CommentResponseDto mapToResponseDto(Comment comment) {
        return CommentResponseDto.builder()
                .post(comment.getPost())
                .content(comment.getContent())
                .build();
    }

    @Override
    public void updateComment(Long userId, Long commentId, CommentUpdateDto commentUpdateDto) {
        Comment comment = commentRepository.findById(commentId)
                .filter(c -> c.getUser().getUserId().equals(userId))
                .orElseThrow(() -> new RuntimeException("Comment not found or does not belong to the user"));
        updateFieldsComment(comment, commentUpdateDto);
        commentRepository.save(comment);
    }

    private void updateFieldsComment(Comment comment, CommentUpdateDto commentUpdateDto) {
        comment.setContent(commentUpdateDto.getContent());
    }

    @Override
    public void deleteComment(Long userId, Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .filter(c -> c.getUser().getUserId().equals(userId))
                .orElseThrow(() -> new RuntimeException("Comment not found or does not belong to the user"));
        commentRepository.delete(comment);
    }
}