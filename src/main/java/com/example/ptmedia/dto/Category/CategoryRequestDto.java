package com.example.ptmedia.dto.Category;

import lombok.Data;

@Data
public class CategoryRequestDto {
    private String name;
    private String color;
    private Boolean active;
}
