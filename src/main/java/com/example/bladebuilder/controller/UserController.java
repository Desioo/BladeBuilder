package com.example.bladebuilder.controller;

import com.example.bladebuilder.converter.UserResponseDTOConverter;
import com.example.bladebuilder.model.response.UserResponseDTO;
import com.example.bladebuilder.service.UserService;
import com.example.bladebuilder.utils.ConverterUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserResponseDTOConverter userResponseDTOConverter;

    @GetMapping("")
    @ResponseBody
    public List<UserResponseDTO> all() {
        return ConverterUtils.convertList(userService.findAll(), userResponseDTOConverter);
    }

}
