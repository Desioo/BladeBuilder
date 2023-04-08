package com.example.bladebuilder.controller;

import com.example.bladebuilder.model.User;
import com.example.bladebuilder.model.response.UserResponseDTO;
import com.example.bladebuilder.service.UserService;
import com.example.bladebuilder.converter.UserResponseDTOConverter;
import com.example.bladebuilder.utils.ConverterUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @DeleteMapping("/{user}")
    public ResponseEntity<String> remove(@PathVariable Optional<User> user){
        try {
            if (user.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            userService.removeByUser(user.get());
            return ResponseEntity.ok("User removed");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
}
