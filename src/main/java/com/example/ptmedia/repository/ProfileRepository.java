package com.example.ptmedia.repository;

import com.example.ptmedia.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    //        DISTINCT eliminate duplicate rows from the result set
//    @Query("SELECT DISTINCT  P.name FROM Profile P ")
//    List<String> GetProfileName();
//
//    @Query("SELECT P FROM Profile P WHERE P.name = :name ")
//    Profile FindByName(@Param("name") String name);

//    @Query("SELECT NEW com.example.ptmedia.service.dto.PostView(p.profile.mobile, p.profile.name, p.id, p.description, p.title )" +
//            "FROM Post p " +
//            "JOIN Profile p2 ON p.id = p2.id ")
//    List<PostView> getPostDetails();

    Boolean existsByMobile(String mobile);

    Profile getById(Long id);
//
//    Boolean existsById(long id);
//
//    Profile findByMobile(String mobile);
//
//    @Query(value = "select  * from  post_view ", nativeQuery = true)
//    List<PostView> getPostDetailss();
//
//    @Query("SELECT P FROM post_view P ")
//    List<PostView> FindByName();
}
