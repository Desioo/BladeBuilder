package com.example.bladebuilder.repository;

import com.example.bladebuilder.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Modifying
    @Query(nativeQuery = true, value = "TRUNCATE TABLE orders")
    void removeAll();

}
