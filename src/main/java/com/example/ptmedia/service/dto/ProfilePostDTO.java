package com.example.ptmedia.service.dto;

import lombok.Data;

@Data
public class ProfilePostDTO {
    private String mobile;
    private String name;
    private Long postId;
    private String description;
    private String title;

    private int value;

    public ProfilePostDTO(String mobile, String name, Long postId, String description, String title ,int value) {
        this.mobile = mobile;
        this.name = name;
        this.postId = postId;
        this.description = description;
        this.title = title;
        this.value= value;
    }

}
