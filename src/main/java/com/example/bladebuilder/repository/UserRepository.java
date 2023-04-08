package com.example.bladebuilder.repository;

import com.example.bladebuilder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("SELECT u FROM User u WHERE u.id = :value OR u.password = :value")
//    Optional<User> findFirstByIdOrPassword(@Param("value") String value);

}
