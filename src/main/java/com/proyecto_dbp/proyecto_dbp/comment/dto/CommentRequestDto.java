package com.proyecto_dbp.proyecto_dbp.comment.dto;

import com.proyecto_dbp.proyecto_dbp.post.domain.Post;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequestDto {
    @NotNull
    private Post post;
    @NotNull
    private String content;
}
