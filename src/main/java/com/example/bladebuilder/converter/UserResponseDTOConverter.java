package com.example.bladebuilder.converter;

import com.example.bladebuilder.model.entity.User;
import com.example.bladebuilder.model.response.UserResponseDTO;
import org.springframework.core.convert.converter.Converter;

public class UserResponseDTOConverter implements Converter<User, UserResponseDTO> {

    @Override
    public UserResponseDTO convert(User user) {

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());

        return userResponseDTO;
    }
}
