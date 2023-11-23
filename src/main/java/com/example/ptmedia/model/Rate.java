package com.example.ptmedia.model;

import jakarta.persistence.*;
import lombok.Data;

@Data //TODO
@Entity
@Table(name = "rate")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id ;
    @ManyToOne
    @JoinColumn(name = "u_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "p_id")
    private Post post;

}
