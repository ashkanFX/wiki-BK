package com.example.ptmedia.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    @Column()
    private String mobile;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rate> rates = new ArrayList<>();

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime creat_Date;
    @Column()
    @UpdateTimestamp
    private LocalDateTime update_Date;

    @Override
    public String toString() {
        return "Profile{" + "id=" + id + ", name='" + name + '\'' + ", mobile='" + mobile + '\'' + ", creat_Date=" + creat_Date + ", update_Date=" + update_Date + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile profile)) return false;
        return Objects.equals(getId(), profile.getId()) && Objects.equals(getName(), profile.getName()) && Objects.equals(getMobile(), profile.getMobile()) && Objects.equals(getCreat_Date(), profile.getCreat_Date()) && Objects.equals(getUpdate_Date(), profile.getUpdate_Date());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getMobile(), getCreat_Date(), getUpdate_Date());
    }


}
