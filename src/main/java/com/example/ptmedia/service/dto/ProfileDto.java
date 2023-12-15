package com.example.ptmedia.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfileDto {
    private Long id;
    private String name;
    private String mobile;
}
