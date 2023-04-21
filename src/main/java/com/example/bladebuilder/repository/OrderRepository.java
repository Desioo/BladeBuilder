package com.example.bladebuilder.repository;

import com.example.bladebuilder.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
