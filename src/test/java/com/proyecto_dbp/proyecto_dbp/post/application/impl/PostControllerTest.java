package com.proyecto_dbp.proyecto_dbp.post.application.impl;

import com.proyecto_dbp.proyecto_dbp.comment.domain.Comment;
import com.proyecto_dbp.proyecto_dbp.post.domain.Post;
import com.proyecto_dbp.proyecto_dbp.post.domain.services.PostService;
import com.proyecto_dbp.proyecto_dbp.post.dto.PostCreateDto;
import com.proyecto_dbp.proyecto_dbp.post.dto.PostUpdateDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PostControllerTest {

    @Mock
    private PostService postService;

    @InjectMocks
    private PostController postController;

    private static final Long POST_ID = 1L;
    private static final Long USER_ID = 1L;

    private static final Post POST = Post.builder()
            .postId(POST_ID)
            .title("Sample Post")
            .content("Sample post content")
            .createdDate(LocalDateTime.now())
            .build();

    private static final PostCreateDto POST_CREATE_DTO = PostCreateDto.builder()
            .title("Sample Post")
            .content("Sample post content")
            .build();

    private static final PostUpdateDto POST_UPDATE_DTO = PostUpdateDto.builder()
            .title("Updated Post")
            .content("Updated post content")
            .build();

    @Test
    void it_should_return_non_null_when_create_post() {
        Mockito.doNothing().when(postService).createPost(POST_CREATE_DTO);

        ResponseEntity<Void> response = postController.createPost(POST_CREATE_DTO);

        assertThat(response).isNotNull();
    }

    @Test
    void it_should_return_no_content_when_create_post() {
        Mockito.doNothing().when(postService).createPost(POST_CREATE_DTO);

        ResponseEntity<Void> response = postController.createPost(POST_CREATE_DTO);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));
    }

    @Test
    void it_should_return_non_null_when_get_post() {
        Mockito.when(postService.getPost(POST_ID)).thenReturn(POST);

        ResponseEntity<Post> response = postController.getPost(POST_ID);

        assertThat(response).isNotNull();
    }

    @Test
    void it_should_return_expected_post_when_get_post() {
        Mockito.when(postService.getPost(POST_ID)).thenReturn(POST);

        ResponseEntity<Post> response = postController.getPost(POST_ID);

        assertThat(response.getBody()).isEqualTo(POST);
    }

    @Test
    void it_should_return_expected_200_when_get_post() {
        Mockito.when(postService.getPost(POST_ID)).thenReturn(POST);

        ResponseEntity<Post> response = postController.getPost(POST_ID);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(200));
    }

    @Test
    void it_should_return_no_content_when_update_post() {
        Mockito.doNothing().when(postService).updatePost(POST_ID, POST_UPDATE_DTO);

        ResponseEntity<Void> response = postController.updatePost(POST_ID, POST_UPDATE_DTO);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));
    }

    @Test
    void it_should_return_no_content_when_delete_post() {
        Mockito.doNothing().when(postService).deletePost(POST_ID);

        ResponseEntity<Void> response = postController.deletePost(POST_ID);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));
    }

    @Test
    void it_should_return_no_content_when_like_post() {
        Mockito.doNothing().when(postService).likePost(POST_ID, USER_ID);

        ResponseEntity<Void> response = postController.likePost(POST_ID, USER_ID);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));
    }

    @Test
    void it_should_return_no_content_when_dislike_post() {
        Mockito.doNothing().when(postService).dislikePost(POST_ID, USER_ID);

        ResponseEntity<Void> response = postController.dislikePost(POST_ID, USER_ID);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));
    }

    @Test
    void it_should_return_no_content_when_comment_post() {
        Comment comment = Comment.builder()
                .commentId(1L)
                .content("Sample comment")
                .build();

        Mockito.doNothing().when(postService).commentPost(POST_ID, comment);

        ResponseEntity<Void> response = postController.commentPost(POST_ID, comment);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));
    }
}
