package com.example.ptmedia.service.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PostRequestDTO {
    private String title;
    private String description;
    private Long profileId;
    private List<Long> categoryIds;
}

