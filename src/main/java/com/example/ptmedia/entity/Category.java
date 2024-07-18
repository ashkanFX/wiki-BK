package com.example.ptmedia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
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

    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    private List<Post> posts ;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;
        return Objects.equals(getId(), category.getId()) && Objects.equals(getName(), category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return "CategoryInterface{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
