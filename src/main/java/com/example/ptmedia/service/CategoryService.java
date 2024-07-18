package com.example.ptmedia.service;

import com.example.ptmedia.dto.Category.CategoryRequestDto;
import com.example.ptmedia.dto.Category.CategoryResponseDto;
import com.example.ptmedia.entity.Category;
import com.example.ptmedia.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategoryService {
    final private CategoryRepository categoryRepository;

    public Category addCategory(CategoryRequestDto categoryRequestDto) {
        Category category = new Category();
        category.setName(categoryRequestDto.getName());
        return this.categoryRepository.save(category);
    }

    public List<CategoryResponseDto> findAll() {
        return this.categoryRepository.findAll().stream().map(category -> {
            CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
            categoryResponseDto.setName(category.getName());
            categoryResponseDto.setId(category.getId());
            return categoryResponseDto;
        }).collect(Collectors.toList());
    }

    public boolean deleteCategory(Long id) {
        try {
            this.categoryRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
