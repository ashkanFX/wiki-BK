package com.example.ptmedia.service.impl;


import com.example.ptmedia.dto.Post.*;
import com.example.ptmedia.dto.Profile.ProfileResponseDto;
import com.example.ptmedia.entity.Category;
import com.example.ptmedia.entity.Post;
import com.example.ptmedia.entity.Profile;
import com.example.ptmedia.repository.CategoryRepository;
import com.example.ptmedia.repository.PostRepository;
import com.example.ptmedia.repository.ProfileRepository;
import com.example.ptmedia.service.PostInterface;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class PostService implements PostInterface {
    private final PostRepository postRepository;
    private final ProfileRepository profileRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Post postRegister(PostRequestDto postRequestDTO) {
        Post post = new Post();
        Set<Category> categories = postRequestDTO.getCategories().stream().map(
                categoryRepository::findById
        ).toList().stream().filter(Optional::isPresent).map(Optional::get).collect(Collectors.toSet());
        Profile profile = this.profileRepository.findById(postRequestDTO.getProfileId()).orElse(null);
        post.setProfile(profile);
        post.setCategories(categories);
        post.setDescription(postRequestDTO.getDescription());
        post.setTitle(postRequestDTO.getTitle());
        return this.postRepository.save(post);
    }

    @Override
    public List<PostResponseDto> getAllPost() {
        return this.postRepository.findAll().stream().map(post -> {
            PostResponseDto postResponseDto = new PostResponseDto();
            ProfileResponseDto profileResponseDto = new ProfileResponseDto();
            postResponseDto.setDescription(post.getDescription());
            postResponseDto.setId(post.getId());
            postResponseDto.setTitle(post.getTitle());
            profileResponseDto.setName(post.getProfile().getName());
            profileResponseDto.setMobile(post.getProfile().getMobile());
            profileResponseDto.setId(post.getProfile().getId());
            postResponseDto.setProfile(profileResponseDto);
            postResponseDto.setCategory(post.getCategories());
            return postResponseDto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<PostResponseDto> getLatestPost() {
        return this.postRepository.findTop4ByOrderByIdDesc().stream().map(post -> {
            PostResponseDto postResponseDto = new PostResponseDto();
            ProfileResponseDto profileResponseDto = new ProfileResponseDto();
            postResponseDto.setDescription(post.getDescription());
            postResponseDto.setId(post.getId());
            postResponseDto.setTitle(post.getTitle());
            profileResponseDto.setName(post.getProfile().getName());
            profileResponseDto.setMobile(post.getProfile().getMobile());
            profileResponseDto.setId(post.getProfile().getId());
            postResponseDto.setProfile(profileResponseDto);
            postResponseDto.setCategory(post.getCategories());
            return postResponseDto;
        }).collect(Collectors.toList());
    }

    @Override
    public PostProfileResponseDto getUserAllPost(long id) {
        Profile profile = profileRepository.findById(id).orElse(null);
        PostProfileResponseDto postProfileResponseDto = new PostProfileResponseDto();
        assert profile != null;
        postProfileResponseDto.setProfileId(profile.getId());
        postProfileResponseDto.setName(profile.getName());
        List<PostProfileDto> posts = this.postRepository.findByProfile_id(id).stream().map(post -> {
            PostProfileDto postProfileDto = new PostProfileDto();
            postProfileDto.setDescription(post.getDescription());
            postProfileDto.setTitle(post.getTitle());
            postProfileDto.setCreateAt(post.getCreateAt());
            postProfileDto.setId(post.getId());
            return postProfileDto;
        }).collect(Collectors.toList());
        postProfileResponseDto.setPosts(posts);
        return postProfileResponseDto;
    }


    @Override
    public List<Post> getCategoryAllPost(long id) {
        return postRepository.findPostsByCategoryId(id);
    }

    @Override
    public Boolean delete(Long id) {
        this.postRepository.deleteById(id);
        return true;
    }

    @Override
    public PostResponseDto findById(Long id) {
        PostResponseDto postResponseDto = new PostResponseDto();
        ProfileResponseDto profileResponseDto = new ProfileResponseDto();
        Post post = this.postRepository.findById(id).orElse(null);
        profileResponseDto.setId(post.getProfile().getId());
        profileResponseDto.setName(post.getProfile().getName());
        profileResponseDto.setMobile(post.getProfile().getMobile());
        postResponseDto.setDescription(post.getDescription());
        postResponseDto.setTitle(post.getTitle());
        postResponseDto.setId(post.getId());
        postResponseDto.setProfile(profileResponseDto);
        return postResponseDto;
    }

    @Override
    public Post updatePost(Long id, PostUpdateDto postUpdateDto) {
        Post post = this.postRepository.findById(id).orElse(null);
        if (postUpdateDto.getDescription() != null) {
            assert post != null;
            post.setDescription(postUpdateDto.getDescription());
        }
        if (postUpdateDto.getTitle() != null) {
            assert post != null;
            post.setTitle(postUpdateDto.getTitle());
        }
        assert post != null;
        return this.postRepository.save(post);
    }
}
