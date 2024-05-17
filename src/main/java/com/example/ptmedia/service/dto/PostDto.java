package com.example.ptmedia.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PostDto {
    private String title;
    private String description;
    private ProfileDto profileDto;
    private List<String> categories;


    @Override
    public String toString() {
        return "PostDto{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", profile=" + profileDto +
                ", categories=" + categories +
                '}';
    }
}
