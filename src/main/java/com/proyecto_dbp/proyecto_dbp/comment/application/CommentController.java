package com.proyecto_dbp.proyecto_dbp.comment.application;

import com.proyecto_dbp.proyecto_dbp.comment.domain.CommentService;
import com.proyecto_dbp.proyecto_dbp.comment.dto.CommentRequestDto;
import com.proyecto_dbp.proyecto_dbp.comment.dto.CommentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

}