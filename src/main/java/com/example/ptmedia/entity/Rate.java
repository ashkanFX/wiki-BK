package com.example.ptmedia.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

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
    @JoinColumn(name = "profile_id")
    @JsonIgnore
    private Profile profile;
    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonIgnore
    private Post post;
    @Override
    public String toString() {
        return "Rate{" +
                "id=" + id +
                ", value=" + value +
                ", profile=" + profile +
                ", post=" + post +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rate rate)) return false;
        return getValue() == rate.getValue() && getId().equals(rate.getId()) && getProfile().equals(rate.getProfile()) && getPost().equals(rate.getPost());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getValue(), getProfile(), getPost());
    }
}
