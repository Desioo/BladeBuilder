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
    public void remove(User user){
        user.setActive(false);
        save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findAllActiveUsers() {
        return userRepository.findAllActiveUsers();
    }

    public User findUserPassword(String password){

        //TODO Hasło i optional

        List<User> all = findAllActiveUsers();

        for (User user : all) {
            if(passwordEncoder.matches(password, user.getPassword())){
                return user;
            }
        }

        return null;

    }
}
