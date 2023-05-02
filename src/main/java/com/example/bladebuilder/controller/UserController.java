package com.example.bladebuilder.controller;

import com.example.bladebuilder.converter.UserResponseDTOConverter;
import com.example.bladebuilder.exception.UserDataTakenException;
import com.example.bladebuilder.model.entity.User;
import com.example.bladebuilder.model.response.UserResponseDTO;
import com.example.bladebuilder.service.UserService;
import com.example.bladebuilder.utils.ConverterUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;
    private final UserResponseDTOConverter userResponseDTOConverter;
    private final BCryptPasswordEncoder passwordEncoder;

    @GetMapping("")
    @ResponseBody
    public List<UserResponseDTO> all() {
        return ConverterUtils.convertList(userService.findAllActiveUsers(), userResponseDTOConverter);
    }

    @PostMapping("")
    @ResponseBody
    public ResponseEntity<String> add(@RequestBody @Valid User user) throws UserDataTakenException {

        userService.checkPasswordIsFree(user.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);

        userService.save(user);

        return ResponseEntity.ok("User add");
    }

    @DeleteMapping("/{user}")
    public ResponseEntity<String> remove(@PathVariable Optional<User> user) {
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        userService.remove(user.get());
        return ResponseEntity.ok("User removed");
    }

    @PutMapping("/{user}")
    public ResponseEntity<String> changeUserName(@PathVariable Optional<User> user, @RequestBody String name) {

        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User userWithNewName = user.get();
                userWithNewName.setName(name);

        userService.save(userWithNewName);

        return ResponseEntity.ok("User name changed");
    }

    @PutMapping("/password/{user}")
    public ResponseEntity<String> changeUserPassword(@PathVariable Optional<User> user, @RequestBody String password) throws UserDataTakenException {

        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        userService.checkPasswordIsFree(password);

        User userWithNewPassword = user.get();
        userWithNewPassword.setPassword(passwordEncoder.encode(password));

        userService.save(userWithNewPassword);

        return ResponseEntity.ok("User password changed");
    }
}
