package com.example.ptmedia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String title;
    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    @JsonIgnore
    private Profile profile;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "post_category",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    @JsonIgnore
    private Set<Category> categories = new HashSet<>();


    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rate> rates = new ArrayList<>();

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime updateAt;
    @UpdateTimestamp
    private LocalDateTime creatAt;


//    @OneToMany(mappedBy ="post" ,cascade = CascadeType.ALL ,orphanRemoval = true)
//    private Set<Rate> rates = new HashSet<>();
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Post post)) return false;
//        return getId() == post.getId() && Objects.equals(getTitle(), post.getTitle()) && Objects.equals(getDescription(), post.getDescription()) && Objects.equals(getProfile(), post.getProfile()) && Objects.equals(getCategories(), post.getCategories()) && Objects.equals(getUpdateAt(), post.getUpdateAt()) && Objects.equals(getCreatAt(), post.getCreatAt());
//    }
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getTitle(), getDescription(), getProfile(), getCategories(), getUpdateAt(), getCreatAt());
//    }
//    @Override
//    public String toString() {
//        return "Post{" + "id=" + id + ", title='" + title + '\'' + ", description='" + description + '\'' + ", profile=" + profile + ", categories=" + categories + ", updateAt=" + updateAt + ", creatAt=" + creatAt + '}';
//    }
}
