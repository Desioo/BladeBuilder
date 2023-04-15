package com.example.bladebuilder.service;

import com.example.bladebuilder.model.entity.User;
import com.example.bladebuilder.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements ServiceInterface<User> {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void remove(User user) {
       userRepository.delete(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public String getUserNameByPassword(String password){

        //TODO Hasło
        System.out.println("password: " + password);

        List<User> all = findAll();

        for (User user : all) {
            if(passwordEncoder.matches(password, user.getPassword())){
                return user.getName();
            }
        }

        return "";

    }

}
