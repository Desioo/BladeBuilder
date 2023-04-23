package com.example.bladebuilder.controller;

import com.example.bladebuilder.converter.OrderListConverter;
import com.example.bladebuilder.model.entity.Order;
import com.example.bladebuilder.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderListConverter orderListConverter;
    private final OrderService orderService;

    @PostMapping()
    @ResponseBody
    public String add(@RequestBody String ordersToConvert) {

        List<Order> orders = orderListConverter.convert(ordersToConvert);

        for (Order order : orders) {
           orderService.save(order);
        }

        return "ok";
    }

    @GetMapping()
    @ResponseBody
    public List<Order> all() {
        return orderService.findAll();
    }

    @DeleteMapping("/{order}")
    @ResponseBody
    public ResponseEntity<String> remove(@PathVariable Optional<Order> order) {

        if (order.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        orderService.remove(order.get());
        return ResponseEntity.ok("Order removed");
    }
}
