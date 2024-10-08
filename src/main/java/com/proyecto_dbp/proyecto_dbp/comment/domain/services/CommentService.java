package com.proyecto_dbp.proyecto_dbp.comment.domain.services;

import com.proyecto_dbp.proyecto_dbp.comment.domain.Comment;
import com.proyecto_dbp.proyecto_dbp.comment.dto.CommentRequestDto;
import com.proyecto_dbp.proyecto_dbp.comment.dto.CommentResponseDto;
import com.proyecto_dbp.proyecto_dbp.comment.dto.CommentUpdateDto;

public interface CommentService {
    Comment postComment(Long userId, CommentRequestDto commentRequestDto);
    CommentResponseDto getComment(Long userId, Long commentId);
    void updateComment(Long userId, Long commentId, CommentUpdateDto commentUpdateDto);
    void deleteComment(Long userId, Long commentId);
}
