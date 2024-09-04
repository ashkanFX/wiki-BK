package com.example.ptmedia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micrometer.common.lang.NonNull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "category")
public class Category {
    @Id
    @Column
    @GeneratedValue()
    Long id;
    @Column
    @Size(min = 3, message = "at least need 3 char")
    @NonNull
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
