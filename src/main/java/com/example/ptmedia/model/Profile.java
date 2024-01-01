package com.example.ptmedia.model;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Data
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
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime creat_Date;
    @Column
    @UpdateTimestamp
    private LocalDateTime update_Date;
}