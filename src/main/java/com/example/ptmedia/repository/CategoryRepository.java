package com.example.ptmedia.repository;

import com.example.ptmedia.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
 }
