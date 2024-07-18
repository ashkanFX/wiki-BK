package com.example.ptmedia.controller;

import com.example.ptmedia.dto.Category.CategoryRequestDto;
import com.example.ptmedia.dto.Category.CategoryResponseDto;
import com.example.ptmedia.model.Category;
import com.example.ptmedia.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/category")
@RequiredArgsConstructor

public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody CategoryRequestDto categoryRequestDto) {

        try {
            Category requestDto = categoryService.addCategory(categoryRequestDto);
            return ResponseEntity.ok(requestDto);

        } catch (Exception exception) {
            exception.printStackTrace();
            ResponseEntity.badRequest().body(exception.getMessage());
        }
        return null ;

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryResponseDto>> addAllCategory() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.deleteCategory(id));
    }


}
