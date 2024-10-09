package com.proyecto_dbp.proyecto_dbp.comment.application.impl;

import com.proyecto_dbp.proyecto_dbp.comment.domain.Comment;
import com.proyecto_dbp.proyecto_dbp.comment.domain.services.CommentService;
import com.proyecto_dbp.proyecto_dbp.comment.dto.CommentRequestDto;
import com.proyecto_dbp.proyecto_dbp.comment.dto.CommentResponseDto;
import com.proyecto_dbp.proyecto_dbp.comment.dto.CommentUpdateDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CommentControllerTest {

    @Test
    void it_should_return_non_null_when_post_comment() {
        Mockito.when(commentService.postComment(USER_ID, COMMENT_REQUEST_DTO))
                .thenReturn(COMMENT);

        assertThat(commentController.postComment(USER_ID, COMMENT_REQUEST_DTO))
                .isNotNull();
    }

    @Test
    void it_should_return_expected_comment_when_post_comment() {
        Mockito.when(commentService.postComment(USER_ID, COMMENT_REQUEST_DTO))
                .thenReturn(COMMENT);

        assertThat(commentController.postComment(USER_ID, COMMENT_REQUEST_DTO).getBody())
                .isEqualTo(COMMENT);
    }

    @Test
    void it_should_return_expected_200_when_post_comment() {
        Mockito.when(commentService.postComment(USER_ID, COMMENT_REQUEST_DTO))
                .thenReturn(COMMENT);

        assertThat(commentController.postComment(USER_ID, COMMENT_REQUEST_DTO).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    void it_should_return_non_null_when_get_comment() {
        Mockito.when(commentService.getComment(USER_ID, COMMENT_ID))
                .thenReturn(COMMENT_RESPONSE_DTO);

        assertThat(commentController.getComment(USER_ID, COMMENT_ID))
                .isNotNull();
    }

    @Test
    void it_should_return_expected_comment_when_get_comment() {
        Mockito.when(commentService.getComment(USER_ID, COMMENT_ID))
                .thenReturn(COMMENT_RESPONSE_DTO);

        assertThat(commentController.getComment(USER_ID, COMMENT_ID).getBody())
                .isEqualTo(COMMENT_RESPONSE_DTO);
    }

    @Test
    void it_should_return_expected_200_when_get_comment() {
        Mockito.when(commentService.getComment(USER_ID, COMMENT_ID))
                .thenReturn(COMMENT_RESPONSE_DTO);

        assertThat(commentController.getComment(USER_ID, COMMENT_ID).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    void it_should_return_no_content_when_update_comment() {
        Mockito.doNothing().when(commentService).updateComment(USER_ID, COMMENT_ID, COMMENT_UPDATE_DTO);

        assertThat(commentController.updateComment(USER_ID, COMMENT_ID, COMMENT_UPDATE_DTO).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(204));
    }

    @Test
    void it_should_return_no_content_when_delete_comment() {
        Mockito.doNothing().when(commentService).deleteComment(USER_ID, COMMENT_ID);

        assertThat(commentController.deleteComment(USER_ID, COMMENT_ID).getStatusCode())
                .isEqualTo(HttpStatusCode.valueOf(204));
    }

    @Mock
    private CommentService commentService;

    @InjectMocks
    private CommentController commentController;

    private static final Long USER_ID = 1L;
    private static final Long COMMENT_ID = 1L;

    private static final Comment COMMENT = Comment.builder()
            .commentId(COMMENT_ID)
            .content("Sample comment")
            .commentDate(LocalDateTime.now())
            .build();

    private static final CommentRequestDto COMMENT_REQUEST_DTO = CommentRequestDto.builder()
            .content("Sample comment")
            .build();

    private static final CommentResponseDto COMMENT_RESPONSE_DTO = CommentResponseDto.builder()
            .content("Sample comment")
            .build();

    private static final CommentUpdateDto COMMENT_UPDATE_DTO = CommentUpdateDto.builder()
            .content("Updated comment")
            .build();
}