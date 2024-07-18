package com.example.ptmedia.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
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
    private List<Post> posts ;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rate> rates ;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createDate;
    @Column()
    @UpdateTimestamp
    private LocalDateTime updateDate;

    @Override
    public String toString() {
        return "Profile{" + "id=" + id + ", name='" + name + '\'' + ", mobile='" + mobile + '\'' + ", create_date=" + createDate + ", update_date=" + updateDate + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile profile)) return false;
        return Objects.equals(getId(), profile.getId()) && Objects.equals(getName(), profile.getName()) && Objects.equals(getMobile(), profile.getMobile()) && Objects.equals(getCreateDate(), profile.getCreateDate()) && Objects.equals(getUpdateDate(), profile.getUpdateDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getMobile(), getCreateDate(), getUpdateDate());
    }


}
