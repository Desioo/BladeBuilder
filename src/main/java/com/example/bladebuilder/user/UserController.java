package com.example.bladebuilder.user;

import com.example.bladebuilder.exception.UserDataTakenException;
import com.example.bladebuilder.utils.ListConverter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Validated
public class UserController {

    private final UserService userService;
    private final UserResponseDTOConverter userResponseDTOConverter;
    private final BCryptPasswordEncoder passwordEncoder;

    @GetMapping("")
    public List<UserResponseDTO> all() {
        return ListConverter.convertList(userService.findAllActiveUsers(), userResponseDTOConverter);
    }

    @Transactional
    @PostMapping("")
    public ResponseEntity<String> add(@RequestBody @Valid User user) throws UserDataTakenException {

        userService.checkPasswordIsFree(user.getPassword());

        User userByName = userService.findInactiveUserByName(user.getName());

        userByName.setName(user.getName());
        userByName.setPassword(passwordEncoder.encode(user.getPassword()));
        userByName.setActive(true);

        userService.save(userByName);


        return ResponseEntity.ok("User add");
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<String> remove(@PathVariable String id) {

        Optional<User> user = userService.findById(Long.parseLong(id));

        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        userService.remove(user.get());
        return ResponseEntity.ok("User removed");
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<String> changeUserName(@PathVariable String id, @RequestBody String name){

        Optional<User> user = userService.findById(Long.parseLong(id));

        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User userWithNewName = user.get();
        userWithNewName.setName(name);

        userService.save(userWithNewName);

        return ResponseEntity.ok("User name changed");
    }

    @Transactional
    @PutMapping("/password/{id}")
    public ResponseEntity<String> changeUserPassword(@PathVariable String id, @RequestBody String password) throws UserDataTakenException {

        Optional<User> user = userService.findById(Long.parseLong(id));

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
