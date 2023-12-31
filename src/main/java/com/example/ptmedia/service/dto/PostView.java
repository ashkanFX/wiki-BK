package com.example.ptmedia.service.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "post_view")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostView {
    @Id
    @GeneratedValue()
     private Long id;

    private String mobile;
    private String name;
    private String description;
    private String title;
    private int total_value;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
