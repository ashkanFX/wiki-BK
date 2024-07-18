package com.example.ptmedia.controller;

import com.example.ptmedia.dto.Post.PostProfileResponseDto;
import com.example.ptmedia.dto.Post.PostRequestDto;
import com.example.ptmedia.dto.Post.PostResponseDto;
import com.example.ptmedia.dto.Post.PostUpdateDto;
import com.example.ptmedia.model.Post;
import com.example.ptmedia.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@AllArgsConstructor
@CrossOrigin()

public class PostController {
    private final PostService postService;

    @PostMapping("/add")
    public ResponseEntity<Post> postRegister(@RequestBody PostRequestDto postRequestDTO) {
        return ResponseEntity.ok(this.postService.postRegister(postRequestDTO));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PostResponseDto>> getAllPost() {
        return ResponseEntity.ok(this.postService.getAllPost());
    }

    @GetMapping("/get/all/post/{id}")
    public ResponseEntity<PostProfileResponseDto> findAllProfilePost(@PathVariable Long id) {
        return ResponseEntity.ok(this.postService.getUserAllPost(id));
    }
    @GetMapping("/get/all/post/category/{id}")
    public ResponseEntity<List<Post>> getCategoryAllPost(@PathVariable Long id) {
        return ResponseEntity.ok(this.postService.getCategoryAllPost(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deletePost(@PathVariable Long id) {
        return ResponseEntity.ok(this.postService.delete(id));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PostResponseDto> findById(@PathVariable long id) {
        return ResponseEntity.ok(this.postService.findById(id));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable long id , @RequestBody PostUpdateDto postUpdateDto) {
        return ResponseEntity.ok(this.postService.updatePost(id , postUpdateDto));
    }

}
