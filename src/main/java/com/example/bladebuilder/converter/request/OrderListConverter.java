package com.example.bladebuilder.converter.request;

import com.example.bladebuilder.exception.IncorrectOrdersException;
import com.example.bladebuilder.model.entity.Order;
import com.example.bladebuilder.utils.ConverterUtils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

public class OrderListConverter implements Converter<String, List<Order>> {

    @Autowired
    private OrderConverter orderConverter;

    private static final String ORDERS_REGEX = "^\"(([\\d ]+\\\\t){2}\\d{4}-\\d{2}-\\d{2}\\\\t((.+)\\\\t){2}" +
            "(.+)\\\\t([\\d ,]+\\\\t){3}([A-Za-z\\d]{0,4})?\\n?)+\"$";

    @Override
    @SneakyThrows
    public List<Order> convert(String orders) {

        if (!orders.matches(ORDERS_REGEX)) {
            throw new IncorrectOrdersException();
        }

        orders = orders.replaceAll("\"", "");

        return ConverterUtils.convertArrayToList(orders.split("\\\\n"), orderConverter);
    }
}
