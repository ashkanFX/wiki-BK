package com.example.ptmedia.repository;

import com.example.ptmedia.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
     List<Post> findByUser_id(Integer id);

     @Query("SELECT p FROM Post p JOIN p.categories c WHERE c.id = :categoryId")
     List<Post> findPostsByCategoryId(@Param("categoryId") Long categoryId);

     @Query(value = "SELECT * FROM Post ORDER BY created_at DESC LIMIT 4", nativeQuery = true)
     List<Post> getLatest();
}
