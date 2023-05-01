package com.example.bladebuilder.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Length(min = 4)
    private String name;

    @NotEmpty
    @Length(min = 4)
    private String password;

    private Boolean active;
}
