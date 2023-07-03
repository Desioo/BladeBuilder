package com.example.bladebuilder.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

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

    private String roles;
}
