package com.example.ptmedia.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "document")
public class Document {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(length = 9000) // Adjust the length accordingly
    @Lob
    private byte[] Content;
    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    private Post post;
    @Column
    private String fileName;

}
