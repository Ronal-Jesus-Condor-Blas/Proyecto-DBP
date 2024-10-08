package com.proyecto_dbp.proyecto_dbp.comment.domain.services.impl;

import com.proyecto_dbp.proyecto_dbp.comment.domain.Comment;
import com.proyecto_dbp.proyecto_dbp.comment.domain.services.CommentService;
import com.proyecto_dbp.proyecto_dbp.comment.dto.CommentRequestDto;
import com.proyecto_dbp.proyecto_dbp.comment.dto.CommentResponseDto;
import com.proyecto_dbp.proyecto_dbp.comment.dto.CommentUpdateDto;
import com.proyecto_dbp.proyecto_dbp.comment.infrastructure.CommentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment postComment(Long userId, CommentRequestDto commentRequestDto) {
        return Optional.of(commentRequestDto)
                .map(commentRequest -> mapToEntity(userId, commentRequest))
                .map(commentRepository::save)
                .orElseThrow(() -> new RuntimeException("Error posting comment"));
    }

    private Comment mapToEntity(Long userId, CommentRequestDto commentRequest) {
        return Comment.builder()
                .user(Integer.parseInt(userId.toString()))
                .post(commentRequest.getPost())
                .content(commentRequest.getContent())
                .commentDate(LocalDateTime.now())
                .build();
    }

    @Override
    public CommentResponseDto getComment(Long userId, Long commentId) {
        return commentRepository.findById(commentId)
            .filter(comment -> comment.getUser().equals(userId.intValue()))
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
        Optional.of(commentId)
            .flatMap(commentRepository::findById)
            .filter(comment -> comment.getUser().equals(userId.intValue()))
            .map(comment -> updateFieldsComment(comment, commentUpdateDto))
            .map(commentRepository::save)
            .orElseThrow(() -> new RuntimeException("Error updating comment"));
    }

    private Comment updateFieldsComment(Comment comment, CommentUpdateDto commentUpdateDto) {
        comment.setContent(commentUpdateDto.getContent());
        return comment;
    }

    @Override
    public void deleteComment(Long userId, Long commentId) {
        Optional.of(commentId)
            .flatMap(commentRepository::findById)
            .filter(comment -> comment.getUser().equals(userId.intValue()))
            .ifPresent(commentRepository::delete);
    }
}
