package com.example.ptmedia.service.dto;

import lombok.Data;

@Data
public class ProfilePostDTO {
    private String mobile;
    private String name;
    private Long postId;
    private String description;
    private String title;


    public ProfilePostDTO(String mobile, String name, Long postId, String description, String title ) {
        this.mobile = mobile;
        this.name = name;
        this.postId = postId;
        this.description = description;
        this.title = title;

    }

}
