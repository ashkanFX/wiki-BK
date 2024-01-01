package com.example.ptmedia.controller;

import com.example.ptmedia.model.Post;
import com.example.ptmedia.service.PostService;
import com.example.ptmedia.service.dto.PostRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/add")
    public ResponseEntity<Post> postRegister(@RequestBody PostRequestDTO postRequestDTO) {
        return ResponseEntity.ok(postService.Register(postRequestDTO));
    }

    @PostMapping("/delete")
    public ResponseEntity<Boolean> postDelete(@RequestParam Long id) {
        return ResponseEntity.ok(postService.Delete(id));
    }

    @PostMapping("/getAll")
    public ResponseEntity<List<Post>> postGetALL() {
        return ResponseEntity.ok(postService.getAllPost());
    }

    @PostMapping("/get")
    public ResponseEntity<Post> postGet(@RequestParam Long id) {
        return ResponseEntity.ok(postService.getPost(id));
    }

}
