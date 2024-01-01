package com.example.ptmedia.service.dto;


import com.example.ptmedia.model.Profile;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PostRequestDTO {
    private String title;
    private String description;

    private Profile profile;
    private List<Long> categoryIds;

    // Getters and setters
}

