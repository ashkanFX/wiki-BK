package com.example.ptmedia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "User")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String password;
    @Column()
    private String mobile;
    @Column()
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rate> rates;

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
        if (!(o instanceof User User)) return false;
        return Objects.equals(getId(), User.getId()) && Objects.equals(getName(), User.getName()) && Objects.equals(getMobile(), User.getMobile()) && Objects.equals(getCreateDate(), User.getCreateDate()) && Objects.equals(getUpdateDate(), User.getUpdateDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getMobile(), getCreateDate(), getUpdateDate());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println(role.getAuthorities());
        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
