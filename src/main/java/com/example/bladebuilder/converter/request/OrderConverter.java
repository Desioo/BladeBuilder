package com.example.bladebuilder.converter.request;

import com.example.bladebuilder.model.entity.Order;
import org.springframework.core.convert.converter.Converter;

import java.util.Map;

public class OrderConverter implements Converter<String, Order> {

    @Override
    public Order convert(String stringToConvert) {

        String[] orderSplit = stringToConvert.split("\\\\t");

        Order order = new Order();

        order.setIdSeq(Integer.parseInt(orderSplit[0].replaceAll(" ", "")));
        order.setSeq(Integer.parseInt(orderSplit[1].replaceAll(" ", "")));
        order.setCustomer(orderSplit[3]);
        order.setDescription(orderSplit[4]);
        order.setInvoiceNumber(orderSplit[5]);
        order.setThickness(orderSplit[6]);
        order.setWidth(orderSplit[7]);

        order.setLocation(orderSplit.length >= 11 ? orderSplit[10] : "");

        return order;
    }
}
