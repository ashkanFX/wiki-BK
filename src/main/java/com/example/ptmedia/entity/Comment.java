//package com.example.ptmedia.model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.Objects;
//
//@Data
//@Entity
//@Table(name = "comment")
//public class Comment {
//    @Id
//    @Column
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    Long id;
//    String description;
//    @ManyToOne
//    @JoinColumn(name = "u_id")
//    private Profile profile;
//    @ManyToOne
//    @JoinColumn(name = "p_id")
//    private Post post;
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Comment comment)) return false;
//        return Objects.equals(getId(), comment.getId()) && Objects.equals(getDescription(), comment.getDescription()) && Objects.equals(getProfile(), comment.getProfile()) && Objects.equals(getPost(), comment.getPost());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getDescription(), getProfile(), getPost());
//    }
//
//    @Override
//    public String toString() {
//        return "Comment{" +
//                "id=" + id +
//                ", description='" + description + '\'' +
//                ", profile=" + profile +
//                ", post=" + post +
//                '}';
//    }
//}
