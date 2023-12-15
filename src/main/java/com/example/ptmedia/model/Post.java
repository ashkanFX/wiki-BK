package com.example.ptmedia.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String title;
    private String description;
    private LocalDateTime creatAt;
    private LocalDateTime updateAt;

    @ManyToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    @JsonBackReference
    private Profile profile;



}
