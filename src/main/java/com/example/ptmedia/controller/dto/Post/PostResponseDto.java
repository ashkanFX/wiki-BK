package com.example.ptmedia.controller.dto.Post;

import com.example.ptmedia.controller.dto.Category.CategoryResponseDto;
import com.example.ptmedia.controller.dto.Profile.ProfileResponseDto;
import com.example.ptmedia.model.Category;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class PostResponseDto {
    private Long id;
    private String title;
    private String description;
    private ProfileResponseDto profile;
    private Set<Category> category;


}
