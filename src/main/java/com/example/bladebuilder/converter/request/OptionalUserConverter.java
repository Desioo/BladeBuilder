package com.example.bladebuilder.converter.request;

import com.example.bladebuilder.model.entity.User;
import com.example.bladebuilder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.Optional;

public class OptionalUserConverter implements Converter<Long, Optional<User>>{

    @Autowired
    private UserService userService;

    @Override
    public Optional<User> convert(Long id) {
        return userService.findById(id);
    }
}
