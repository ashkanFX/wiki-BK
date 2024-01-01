package com.example.ptmedia.controller;

import com.example.ptmedia.model.Comment;
import com.example.ptmedia.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/add")
    public ResponseEntity<Comment> postRegister(@RequestBody Comment comment) {
        return ResponseEntity.ok(commentService.Register(comment));
    }
}
