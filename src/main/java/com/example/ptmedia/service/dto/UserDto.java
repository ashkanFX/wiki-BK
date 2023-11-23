package com.example.ptmedia.service.dto;

import com.example.ptmedia.model.Post;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String password;
    private String mobile;
    private List<Post> posts;
}
