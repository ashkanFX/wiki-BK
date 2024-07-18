package com.example.ptmedia.service;


import com.example.ptmedia.dto.Post.*;
import com.example.ptmedia.dto.Profile.ProfileResponseDto;
import com.example.ptmedia.model.Category;
import com.example.ptmedia.model.Post;
import com.example.ptmedia.model.Profile;
import com.example.ptmedia.repository.CategoryRepository;
import com.example.ptmedia.repository.PostRepository;
import com.example.ptmedia.repository.ProfileRepository;
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
public class PostService {
    private final PostRepository postRepository;
    private final ProfileRepository profileRepository;
    private final CategoryRepository categoryRepository;


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

    public List<Post> getCategoryAllPost(long id) {
        return postRepository.findPostsByCategoryId(id);
    }

    public Boolean delete(Long id) {
            this.postRepository.deleteById(id);
            return true;
    }

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
    //    private final ProfileRepository profileRepository;
//   private final CategoryRepository categoryRepository;
//
//    public Post Register(PostRequestDto postRequestDTO) {
//
//        Post post = new Post();
//        post.setTitle(postRequestDTO.getTitle());
//        post.setProfile(profileRepository.findById(postRequestDTO.getProfileId()).orElseThrow(null));
//        post.setDescription(postRequestDTO.getDescription());
//      List<Category> categories = categoryRepository.findAllById(postRequestDTO.getCategoryIds());
//        post.setCategories(new HashSet<>(categories));
//
//        postRepository.save(post);
//        return postRepository.save(post);
//    }
//
//    public boolean Delete(Long id) {
//        try {
//            postRepository.deleteById(id);
//            return true;
//        } catch (Exception exception) {
//            return false;
//        }
//    }
//
//    public List<Post> getAllPost() {
//
//
//        return postRepository.findAll();
//    }
//
//    public Post getPost(Long id) {
//        Optional<Post> post = postRepository.findById(id);
//        post.ifPresent(value -> {
//            Optional<Profile> profile = profileRepository.findById(value.getId());
//            ProfileDto profileDto = new ProfileDto();
//            PostProfileDto postDto = new PostProfileDto();
//            ArrayList<String> categories = new ArrayList<>();
//            value.getCategories().forEach(item -> {
//                profileDto.setName(value.getProfile().getName());
//                profileDto.setId(value.getProfile().getId());
//                categories.add(item.getName());
//                postDto.setCategories(categories);
//                postDto.setDescription(value.getDescription());
//                postDto.setTitle(value.getTitle());
//                postDto.setTitle(value.getTitle());
//                postDto.setProfileDto(profileDto);
//            });
    //        });
//        return postRepository.findById(id).orElseThrow(null);
//    }
}
