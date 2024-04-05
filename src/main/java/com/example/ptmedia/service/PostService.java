package com.example.ptmedia.service;

import com.example.ptmedia.model.Category;
import com.example.ptmedia.model.Post;
import com.example.ptmedia.repository.CategoryRepository;
import com.example.ptmedia.repository.PostRepository;
import com.example.ptmedia.service.dto.PostRequestDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class PostService {
        private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;

    public Post Register(PostRequestDTO postRequestDTO) {

        Post post = new Post();
        post.setTitle(postRequestDTO.getTitle());
        post.setProfile(postRequestDTO.getProfile());
        post.setDescription(postRequestDTO.getDescription());


        List<Category> categories = categoryRepository.findAllById(postRequestDTO.getCategoryIds());
        post.setCategories(new HashSet<>(categories));

        postRepository.save(post);
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
