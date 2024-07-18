package com.example.ptmedia.service;

import com.example.ptmedia.dto.Category.CategoryRequestDto;
import com.example.ptmedia.entity.Category;

public interface CategoryInterface {
    Category addCategory(CategoryRequestDto requestDto) throws Exception ;

}
