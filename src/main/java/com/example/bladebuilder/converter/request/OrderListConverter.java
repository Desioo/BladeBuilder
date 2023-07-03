package com.example.bladebuilder.converter.request;

import com.example.bladebuilder.exception.IncorrectOrdersException;
import com.example.bladebuilder.model.entity.Order;
import com.example.bladebuilder.model.reguest.order.OrderMapper;
import com.example.bladebuilder.model.reguest.order.OrderMapperKey;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.*;
import java.util.stream.Collectors;

public class OrderListConverter implements Converter<String, List<Order>> {

    @Autowired
    private OrderConverter orderConverter;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    @SneakyThrows
    public List<Order> convert(String orders) {

        List<OrderMapperKey> orderMapperKeyList = orderMapper.getOrderMapperKeyList();

        for (OrderMapperKey mapperKey : orderMapperKeyList) {
            if (orders.matches(mapperKey.getRegex())) {
                orders = orders.replaceAll("\"", "");
                return convertOrdersList(orders.split("\\\\n"), orderConverter, mapperKey);
            }
        }

        throw new IncorrectOrdersException();

    }

    private static List<Order> convertOrdersList(
            String[] list, Converter<Map<String, Object>, Order> converter, OrderMapperKey mapperKey) {
        Map<String, Object> map = new HashMap<>();
        map.put("elementsIndex", mapperKey);
        return Arrays.stream(list)
                .map(e -> {
                    map.put("orderToConvert", e);
                    return converter.convert(map);
                })
                .collect(Collectors.toList());
    }
}



