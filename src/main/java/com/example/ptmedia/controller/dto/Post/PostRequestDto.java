package com.example.ptmedia.controller.dto.Post;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PostRequestDto {
    private String title;
    private String description;
    private Long profileId;
    private List<Long> categories ;
}

