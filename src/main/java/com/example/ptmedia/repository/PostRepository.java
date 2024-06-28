package com.example.ptmedia.repository;

import com.example.ptmedia.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post , Long> {
     List<Post> findByProfile_id(Long id);
     @Query("SELECT p FROM Post p JOIN p.categories c WHERE c.id = :categoryId")
     List<Post> findPostsByCategoryId(@Param("categoryId") Long categoryId);
}
