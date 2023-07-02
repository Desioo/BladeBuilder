package com.example.bladebuilder.converter.request;

import com.example.bladebuilder.exception.IncorrectOrdersException;
import com.example.bladebuilder.model.entity.Order;
import com.example.bladebuilder.utils.ListConverter;
import com.example.bladebuilder.utils.RegexMapMatcher;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.Map;

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
                return ListConverter.convertArrayToList(orders.split("\\\\n"), orderConverter);
            }

        }

        throw new IncorrectOrdersException();

    }
}
