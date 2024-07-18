package com.example.ptmedia.dto.Post;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostProfileDto {
    private Long id ;
    private String title ;
    private String description ;
    private LocalDateTime CreatAt ;
}
