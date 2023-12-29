package com.example.ptmedia.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "rate")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    private int value;
    @ManyToOne
    @JoinColumn(name = "u_id")
    @JsonBackReference
    private Profile profile;
    @ManyToOne
    @JoinColumn(name = "p_id")
    private Post post;

}
