package com.example.ptmedia.service.impl;

import com.example.ptmedia.dto.Category.CategoryRequestDto;
import com.example.ptmedia.dto.Category.CategoryResponseDto;
import com.example.ptmedia.entity.Category;
import com.example.ptmedia.repository.CategoryRepository;
import com.example.ptmedia.service.CategoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryService implements CategoryInterface {
    final private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(CategoryRequestDto categoryRequestDto) {
        Category category = new Category();
        category.setName(categoryRequestDto.getName());
        return this.categoryRepository.save(category);
    }

    @Override
    public List<CategoryResponseDto> findAllCategory() {
        return this.categoryRepository.findAll().stream().map(category -> {
            CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
            categoryResponseDto.setName(category.getName());
            categoryResponseDto.setId(category.getId());
            return categoryResponseDto;
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteCategory(Long id) {
        this.categoryRepository.deleteById(id);
    }


}
