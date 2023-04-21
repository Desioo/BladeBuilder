package com.example.bladebuilder.controller;

import com.example.bladebuilder.converter.OrderListConverter;
import com.example.bladebuilder.model.entity.Order;
import com.example.bladebuilder.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
