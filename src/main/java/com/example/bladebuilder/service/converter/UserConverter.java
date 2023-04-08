package com.example.bladebuilder.service.converter;

import com.example.bladebuilder.model.User;
import com.example.bladebuilder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.Optional;

public class UserConverter implements Converter<String, Optional<User>>{

    @Autowired
    private UserService userService;

    @Override
    public Optional<User> convert(String value) {
        return userService.findUserByIdOrPassword(value);
    }
}
