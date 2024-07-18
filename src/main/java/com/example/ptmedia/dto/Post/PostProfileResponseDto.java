package com.example.ptmedia.dto.Post;

import lombok.Data;

import java.util.List;
@Data
public class PostProfileResponseDto {
    private String name;
    private Long profileId;
    private List<PostProfileDto> posts;
}
