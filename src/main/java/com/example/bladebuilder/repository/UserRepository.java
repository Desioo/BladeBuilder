package com.example.bladebuilder.repository;

import com.example.bladebuilder.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.active = true")
    List<User> findAllActiveUsers();

    Optional<User> findFirstByName(String name);

    @Query("SELECT u FROM User u WHERE u.roles = :roles")
    List<User> findAllUserByRoles(@Param("roles") String roles);
}
