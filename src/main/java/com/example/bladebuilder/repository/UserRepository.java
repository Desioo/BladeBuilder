package com.example.bladebuilder.repository;

import com.example.bladebuilder.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findFirstByPassword(String password);

}
