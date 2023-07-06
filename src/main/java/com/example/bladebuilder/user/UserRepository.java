package com.example.bladebuilder.user;

import com.example.bladebuilder.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.active = true")
    List<User> findAllActiveUsers();

    Optional<User> findFirstByName(String name);

    List<User> findAllByRoles(Role role);
}
