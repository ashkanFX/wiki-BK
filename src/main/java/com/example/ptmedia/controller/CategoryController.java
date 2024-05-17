package com.example.ptmedia.controller;

import com.example.ptmedia.model.Category;
import com.example.ptmedia.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/getAll")
    public ResponseEntity<List<Category>> postDelete() {
        return ResponseEntity.ok(categoryService.getAll());
    }


}
