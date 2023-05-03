package com.example.bladebuilder.service;

import com.example.bladebuilder.exception.IncorrectPasswordException;
import com.example.bladebuilder.exception.UserDataTakenException;
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

    public User findUserByPassword(String password) throws IncorrectPasswordException {
        return findOptionalUserByPassword(password).orElseThrow(IncorrectPasswordException::new);
    }

    public Optional<User> findOptionalUserByName(String name) {
        return userRepository.findFirstByName(name);
    }

    public void checkPasswordIsFree(String password) throws UserDataTakenException {

        if (findOptionalUserByPassword(password).isPresent()) {
            throw new UserDataTakenException();
        }

    }

    private Optional<User> findOptionalUserByPassword(String password) {

        return findAllActiveUsers().stream()
                .filter(user -> passwordEncoder.matches(password, user.getPassword()))
                .findFirst();

    }

    public User findInactiveUserByName(String name) throws UserDataTakenException {

        return findOptionalUserByName(name)
                .filter(user -> !user.getActive())
                .orElseThrow(UserDataTakenException::new);

    }
}
