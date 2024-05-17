package com.example.ptmedia.service;

import com.example.ptmedia.model.Category;
import com.example.ptmedia.model.Post;
import com.example.ptmedia.model.Profile;
import com.example.ptmedia.repository.CategoryRepository;
import com.example.ptmedia.repository.PostRepository;
import com.example.ptmedia.repository.ProfileRepository;
import com.example.ptmedia.service.dto.PostDto;
import com.example.ptmedia.service.dto.PostRequestDTO;
import com.example.ptmedia.service.dto.ProfileDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final ProfileRepository profileRepository;
    private final CategoryRepository categoryRepository;

    public Post Register(PostRequestDTO postRequestDTO) {

        Post post = new Post();
        post.setTitle(postRequestDTO.getTitle());
        post.setProfile(profileRepository.findById(postRequestDTO.getProfileId()).orElseThrow(null));
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
        Optional<Post> post = postRepository.findById(id);
        post.ifPresent(value -> {
            Optional<Profile> profile = profileRepository.findById(value.getId());
            ProfileDto profileDto = new ProfileDto();
            PostDto postDto = new PostDto();
            ArrayList<String> categories = new ArrayList<>();
            value.getCategories().forEach(item -> {
                profileDto.setName(value.getProfile().getName());
                profileDto.setId(value.getProfile().getId());

                categories.add(item.getName());

                postDto.setCategories(categories);
                postDto.setDescription(value.getDescription());
                postDto.setTitle(value.getTitle());
                postDto.setTitle(value.getTitle());
                postDto.setProfileDto(profileDto);
            });
            System.out.println(postDto);
        });
        return postRepository.findById(id).orElseThrow(null);
    }
}
