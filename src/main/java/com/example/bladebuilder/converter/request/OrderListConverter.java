package com.example.bladebuilder.converter.request;

import com.example.bladebuilder.converter.request.OrderConverter;
import com.example.bladebuilder.model.entity.Order;
import com.example.bladebuilder.utils.ConverterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

public class OrderListConverter implements Converter<String, List<Order>> {

    @Autowired
    private OrderConverter orderConverter;

    @Override
    public List<Order> convert(String orders) {

        orders = orders.replaceAll("\"", "");

        return ConverterUtils.convertArrayToList(orders.split("\\\\n"), orderConverter);
    }
}
