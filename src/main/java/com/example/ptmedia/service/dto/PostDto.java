package com.example.ptmedia.service.dto;

import com.example.ptmedia.model.Profile;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class PostDto {
    private String title;
    private String description;
    private Profile profile;
}
