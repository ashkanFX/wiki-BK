package com.example.ptmedia.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id ;
    @Column
    private String title;
    private String description;
    private String rate;
    private LocalDateTime creatAt;
    private LocalDateTime updateAt;
    @ManyToOne
    @JoinColumn(name = "u_id")
    private User user;

//    private fileLocation img

}
