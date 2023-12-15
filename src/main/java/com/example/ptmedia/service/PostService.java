package com.example.ptmedia.service;

import com.example.ptmedia.model.Post;
import com.example.ptmedia.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Post Register(Post post) {
        return postRepository.save(post);
    }

    public boolean Delete(Long id) {
        try {
            postRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    public Post getPost(Long id) {
        return postRepository.findById(id).orElseThrow(null);
    }
}
