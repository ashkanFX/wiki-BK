package com.example.ptmedia.service;

import com.example.ptmedia.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryService {
    final private CategoryRepository categoryRepository ;

}
