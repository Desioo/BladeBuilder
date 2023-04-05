package com.example.bladebuilder.repository;

import com.example.bladebuilder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
