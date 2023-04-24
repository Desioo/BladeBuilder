package com.example.bladebuilder.converter;

import com.example.bladebuilder.model.entity.Order;
import com.example.bladebuilder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.Optional;

public class OptionalOrderByIdConverter implements Converter<String, Optional<Order>> {

    @Autowired
    private OrderService orderService;

    @Override
    public Optional<Order> convert(String id) {
        return orderService.findById(Long.parseLong(id));
    }

}
