package com.example.bladebuilder.user;

import org.springframework.core.convert.converter.Converter;

public class UserResponseDTOConverter implements Converter<User, UserResponseDTO> {

    @Override
    public UserResponseDTO convert(User user) {

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setActive(user.getActive());

        return userResponseDTO;
    }
}
