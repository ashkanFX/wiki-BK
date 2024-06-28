package com.example.ptmedia.controller.dto.Post;

import lombok.Data;

import java.util.List;
@Data
public class PostProfileResponseDto {
    private String name;
    private Long ProfileId;
    private List<PostProfileDto> posts;
}
