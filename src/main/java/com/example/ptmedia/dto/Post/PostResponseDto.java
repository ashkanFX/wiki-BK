package com.example.ptmedia.dto.Post;

import com.example.ptmedia.dto.Profile.ProfileResponseDto;
import com.example.ptmedia.entity.Category;
import lombok.Data;

import java.util.Set;

@Data
public class PostResponseDto {
    private Long id;
    private String title;
    private String description;
    private ProfileResponseDto profile;
    private Set<Category> category;


}
