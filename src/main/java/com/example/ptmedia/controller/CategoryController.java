package com.example.ptmedia.controller;

import com.example.ptmedia.dto.Category.CategoryRequestDto;
import com.example.ptmedia.dto.Category.CategoryResponseDto;
import com.example.ptmedia.entity.Category;
import com.example.ptmedia.exception.message.NotFoundException;
import com.example.ptmedia.service.impl.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/add")
    public Category addCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        try {
            return categoryService.addCategory(categoryRequestDto);

        } catch (Exception exception) {
            exception.printStackTrace();
            ResponseEntity.badRequest().body(exception.getMessage());
        }
        return null ;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryResponseDto>> addAllCategory() {
        try {
            return ResponseEntity.ok(categoryService.findAllCategory());
        } catch (Exception exception) {
            throw new NotFoundException("can not find any category");
        }
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }


}
