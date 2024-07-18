package com.example.ptmedia.service;

import com.example.ptmedia.dto.Category.CategoryRequestDto;
import com.example.ptmedia.dto.Category.CategoryResponseDto;
import com.example.ptmedia.entity.Category;

import java.util.List;

public interface CategoryInterface {
    Category addCategory(CategoryRequestDto requestDto) throws Exception;

    List<CategoryResponseDto> findAllCategory() throws Exception;

    void deleteCategory(Long id);
}
