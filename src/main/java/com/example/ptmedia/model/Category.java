package com.example.ptmedia.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "category")
public class Category {
    @Id
    @Column
    @GeneratedValue()
    Long id;
    @Column
    String name;


//    @ManyToMany(mappedBy = "categories")
//    private Set<Post> posts = new HashSet<>();
}
