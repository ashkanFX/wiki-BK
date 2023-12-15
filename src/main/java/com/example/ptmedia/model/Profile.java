package com.example.ptmedia.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Profile")
public class Profile {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String mobile;
    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Post> post;

}