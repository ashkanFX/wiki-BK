package com.example.ptmedia.controller.dto;

import com.example.ptmedia.model.Post;
import lombok.Data;

import java.util.List;

@Data
public class UserRegisterRequestDto {
    private String name;
    private String password;
    private String mobile;
    private List<Post> posts;
}
