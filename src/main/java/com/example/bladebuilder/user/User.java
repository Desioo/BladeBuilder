package com.example.bladebuilder.user;

import com.example.bladebuilder.security.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Length(min = 4)
    @Column(unique = true)
    private String name;

    @NotBlank
    @Length(min = 4)
    private String password;

    private Boolean active;

    //TODO Eager

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JoinColumn()
    private List<Role> roles;
}