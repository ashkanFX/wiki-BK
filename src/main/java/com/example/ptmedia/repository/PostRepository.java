package com.example.ptmedia.repository;

import com.example.ptmedia.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post , Long> {
     List<Post> findByProfile_id(Long id);
     List<Post> findTop4ByOrderByIdDesc();
     @Query("SELECT p FROM Post p JOIN p.categories c WHERE c.id = :categoryId")
     List<Post> findPostsByCategoryId(@Param("categoryId") Long categoryId);
}
