package com.example.bladebuilder.converter;

import com.example.bladebuilder.model.entity.Order;
import org.springframework.core.convert.converter.Converter;

public class OrderConverter implements Converter<String, Order> {

    @Override
    public Order convert(String stringToConvert) {

        String[] orderSplit = stringToConvert.split("\\\\t");

        Order order = new Order();

        order.setIdSeq(Integer.parseInt(orderSplit[0]));
        order.setSeq(Integer.parseInt(orderSplit[1]));
        order.setCustomer(orderSplit[3]);
        order.setDescription(orderSplit[4]);
        order.setInvoiceNumber(orderSplit[5]);
        order.setThickness(orderSplit[6]);
        order.setWidth(orderSplit[7]);

        if (orderSplit.length >= 11) {
            order.setLocation(orderSplit[10]);
        } else {
            order.setLocation("");
        }

        return order;
    }
}
