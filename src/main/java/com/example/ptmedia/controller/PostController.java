package com.example.ptmedia.controller;

import com.example.ptmedia.dto.Post.PostProfileResponseDto;
import com.example.ptmedia.dto.Post.PostRequestDto;
import com.example.ptmedia.dto.Post.PostResponseDto;
import com.example.ptmedia.dto.Post.PostUpdateDto;
import com.example.ptmedia.entity.Post;
import com.example.ptmedia.service.impl.PostService;
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
    public void postRegister(@RequestBody PostRequestDto postRequestDTO) {
        System.out.println();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PostResponseDto>> getAllPost() {
        return ResponseEntity.ok(this.postService.getAllPost());
    }
    @GetMapping("/latest")
    public ResponseEntity<List<PostResponseDto>> getLatestPost() {
        return ResponseEntity.ok(this.postService.getLatestPost());
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
