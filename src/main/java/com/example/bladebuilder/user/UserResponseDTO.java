package com.example.bladebuilder.user;

import lombok.Data;

@Data
public class UserResponseDTO {

    private long id;

    private String name;

    private Boolean active;
}
