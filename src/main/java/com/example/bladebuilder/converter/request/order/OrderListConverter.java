package com.example.bladebuilder.converter.request.order;

import com.example.bladebuilder.exception.IncorrectOrdersException;
import com.example.bladebuilder.model.entity.Order;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.Arrays;
import java.util.HashMap;
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

        //TODO dokończyć (Usunąć zbędne klasy, przenieść do innego pakietu)

        String correctOrders = removeRedundantCharacters(orders);

        return orderMapperKeyList.stream()
                .filter(mapperKey -> correctOrders.matches(mapperKey.getRegex()))
                .findFirst()
                .map(mapperKey -> convertOrdersList(correctOrders.split("\\\\n"), orderConverter, mapperKey))
                .orElseThrow(IncorrectOrdersException::new);
    }

    private static String removeRedundantCharacters(String orders){
        return orders
                .replaceAll("^\"", "")
                .replaceAll("\\\\n\"$", "")
                .replaceAll("\"$", "");
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



