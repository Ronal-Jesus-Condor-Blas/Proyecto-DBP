package com.proyecto_dbp.proyecto_dbp.comment.application.impl;

import com.proyecto_dbp.proyecto_dbp.comment.application.CommentApi;
import com.proyecto_dbp.proyecto_dbp.comment.domain.Comment;
import com.proyecto_dbp.proyecto_dbp.comment.domain.services.CommentService;
import com.proyecto_dbp.proyecto_dbp.comment.dto.CommentRequestDto;
import com.proyecto_dbp.proyecto_dbp.comment.dto.CommentResponseDto;
import com.proyecto_dbp.proyecto_dbp.comment.dto.CommentUpdateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController implements CommentApi {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    public ResponseEntity<Comment> postComment(Long userId, CommentRequestDto commentRequestDto) {
        return ResponseEntity.ok(commentService.postComment(userId, commentRequestDto));
    }

    @Override
    public ResponseEntity<CommentResponseDto> getComment(Long userId, Long commentId) {
        return ResponseEntity.ok(commentService.getComment(userId, commentId));
    }

    @Override
    public ResponseEntity<Void> updateComment(Long userId, Long commentId, CommentUpdateDto commentUpdateDto) {
        commentService.updateComment(userId, commentId, commentUpdateDto);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteComment(Long userId, Long commentId) {
        commentService.deleteComment(userId, commentId);
        return ResponseEntity.noContent().build();
    }
}
