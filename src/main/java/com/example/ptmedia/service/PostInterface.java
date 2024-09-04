package com.example.ptmedia.service;

import com.example.ptmedia.dto.Post.PostProfileResponseDto;
import com.example.ptmedia.dto.Post.PostRequestDto;
import com.example.ptmedia.dto.Post.PostResponseDto;
import com.example.ptmedia.dto.Post.PostUpdateDto;
import com.example.ptmedia.entity.Post;

import java.util.List;

public interface PostInterface {
    Post postRegister(PostRequestDto postRequestDTO) throws Exception;

    List<PostResponseDto> getAllPost() throws Exception;

    PostProfileResponseDto getUserAllPost(Integer id) throws Exception;

    List<Post> getCategoryAllPost(long id) throws Exception;

    Boolean delete(Long id) throws Exception;

    PostResponseDto findById(Long id) throws Exception;

    List<Post> getLatest();

    Post updatePost(Long id, PostUpdateDto postUpdateDto) throws Exception;
}
