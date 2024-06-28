package com.example.ptmedia.controller.dto.Post;

import com.example.ptmedia.controller.dto.Profile.ProfileResponseDto;
import lombok.Data;

@Data
public class PostResponseDto {
    private Long id  ;
    private String title ;
    private String description ;
    private ProfileResponseDto profile ;
//    private String description ;


}
