package com.example.ptmedia.repository;

import com.example.ptmedia.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
 }
