package com.example.ptmedia.dto.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponseDto {
    private Long id;
    private String name;
    private String color;
    private Boolean active;
}
