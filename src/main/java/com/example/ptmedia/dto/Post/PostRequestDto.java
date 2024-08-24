package com.example.ptmedia.dto.Post;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PostRequestDto {
    private String title;
    private String description;
    private Integer profileId;
    private List<Long> categories ;
}

