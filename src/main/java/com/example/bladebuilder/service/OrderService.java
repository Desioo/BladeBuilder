package com.example.bladebuilder.service;

import com.example.bladebuilder.model.entity.Order;
import com.example.bladebuilder.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderService implements ServiceInterface<Order> {

    private final OrderRepository orderRepository;

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void remove(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Transactional
    public void removeAllOrders(){
        orderRepository.removeAll();
    }
}
