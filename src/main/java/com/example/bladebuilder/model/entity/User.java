package com.example.bladebuilder.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

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

    @Length(min = 4)
    @NotBlank
    private String password;

    private Boolean active;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
}
