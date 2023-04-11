package com.example.bladebuilder.service;

import com.example.bladebuilder.model.entity.User;
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

    public Optional<User> findUserByPassword(String password){
        return  userRepository.findFirstByPassword(password);
    }

    public String getUserNameByPassword(String password){

        Optional<User> userByPassword = findUserByPassword(password);

        if(userByPassword.isPresent()){
            return userByPassword.get().getName();
        }else{
            return "";
        }

    }

}
