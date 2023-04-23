package com.example.bladebuilder.repository;

import com.example.bladebuilder.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.active = true")
    List<User> findAllActiveUsers();

}
