package com.example.bladebuilder.controller;

import com.example.bladebuilder.converter.request.OrderListConverter;
import com.example.bladebuilder.model.entity.Order;
import com.example.bladebuilder.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderListConverter orderListConverter;
    private final OrderService orderService;

    @Transactional
    @PostMapping()
    public String add(@RequestBody String ordersToConvert) {

        List<Order> orders = orderListConverter.convert(ordersToConvert);

        orderService.removeAllOrders();

        for (Order order : orders) {
            orderService.save(order);
        }

        return "ok";
    }

    @GetMapping()
    public List<Order> all() {
        return orderService.findAll();
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<String> remove(@PathVariable String id) {

        Optional<Order> order = orderService.findById(Long.parseLong(id));

        if (order.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        orderService.remove(order.get());
        return ResponseEntity.ok("Order removed");
    }
}
