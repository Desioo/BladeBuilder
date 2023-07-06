package com.example.bladebuilder.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Modifying
    @Query(nativeQuery = true, value = "TRUNCATE TABLE orders")
    void removeAll();

}
