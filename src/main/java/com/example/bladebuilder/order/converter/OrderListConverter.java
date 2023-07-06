package com.example.bladebuilder.order.converter;

import com.example.bladebuilder.exception.IncorrectOrdersException;
import com.example.bladebuilder.order.Order;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderListConverter implements Converter<String, List<Order>> {

    @Autowired
    private OrderConverter orderConverter;

    @Autowired
    private OrderMapperKeyService orderMapper;

    @Override
    @SneakyThrows
    public List<Order> convert(@NonNull String orders) {

        List<OrderMapperKey> orderMapperKeyList = orderMapper.getOrderMapperKeyList();

        String correctOrders = removeRedundantCharacters(orders);

        return orderMapperKeyList.stream()
                .filter(mapperKey -> correctOrders.matches(mapperKey.getRegex()))
                .findFirst()
                .map(mapperKey -> convertOrdersList(correctOrders.split("\\\\n"), orderConverter, mapperKey))
                .orElseThrow(IncorrectOrdersException::new);
    }

    private static String removeRedundantCharacters(String orders) {
        return orders
                .replaceAll("^\"", "")
                .replaceAll("\\\\n\"$", "")
                .replaceAll("\"$", "");
    }

    private static List<Order> convertOrdersList(String[] list, Converter<Map<String, Object>, Order> converter,
                                                 OrderMapperKey mapperKey) {

        return Arrays.stream(list)
                .map(order -> converter.convert(Map.of("orderToConvert", order, "elementsIndex", mapperKey)))
                .collect(Collectors.toList());
    }
}



