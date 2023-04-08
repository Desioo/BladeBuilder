package com.example.bladebuilder.service;

import com.example.bladebuilder.model.User;
import com.example.bladebuilder.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements ServiceInterface<User> {

    private final UserRepository userRepository;

    @Override
    public void save(User o) {
        userRepository.save(o);
    }

    @Override
    public void remove(Long id) {
        Optional<User> userOptional = findById(id);
        userOptional.ifPresent(userRepository::delete);
    }

    public void removeByUser(User user){
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

    public Optional<User> findUserByIdOrPassword(String value){
        return  userRepository.findFirstByIdOrPassword(value);
    }

}
