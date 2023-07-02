package com.example.bladebuilder.converter.request;

import com.example.bladebuilder.exception.IncorrectOrdersException;
import com.example.bladebuilder.model.entity.Order;
import com.example.bladebuilder.utils.ListConverter;
import com.example.bladebuilder.utils.RegexMapMatcher;
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
    private RegexMapMatcher regexMapMatcher;

    @Override
    @SneakyThrows
    public List<Order> convert(String orders) {

        Map<String, Map<String, Integer>> map = regexMapMatcher.getRegexELementsIndexMap();

        for (Map.Entry<String, Map<String, Integer>> regex : map.entrySet()) {

            if (orders.matches(regex.getKey())) {
                orders = orders.replaceAll("\"", "");
                return convertOrdersList(orders.split("\\\\n"), orderConverter, map.get(regex.getKey()));
            }

        }

        throw new IncorrectOrdersException();

    }

    private static List<Order> convertOrdersList(
            String[] list, Converter<Map<String, Map<String, Integer>>, Order>converter, Map<String, Integer> map){
        return Arrays.stream(list)
                .map(e -> converter.convert(Map.of(e, map))).collect(Collectors.toList());
    }

}
