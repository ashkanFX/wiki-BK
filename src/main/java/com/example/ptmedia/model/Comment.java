package com.example.ptmedia.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String description;
    @ManyToOne
    @JoinColumn(name = "u_id")
    private Profile profile;
    @ManyToOne
    @JoinColumn(name = "p_id")
    private Post post;

}