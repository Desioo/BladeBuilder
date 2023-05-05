package com.example.bladebuilder.converter.request;

import com.example.bladebuilder.model.entity.Order;
import org.springframework.core.convert.converter.Converter;

public class OrderConverter implements Converter<String, Order> {

    @Override
    public Order convert(String stringToConvert) {

        String[] orderSplit = stringToConvert.split("\\\\t");

        Order order = new Order();

        order.setIdSeq(Integer.parseInt(orderSplit[0]));
        order.setSeq(Integer.parseInt(orderSplit[5]));
        order.setCustomer(orderSplit[6]);
        order.setDescription(orderSplit[8]);
        order.setInvoiceNumber(orderSplit[7]);
        order.setThickness(orderSplit[9]);
        order.setWidth(orderSplit[10]);

        if (orderSplit.length >= 15) {
            order.setLocation(orderSplit[14]);
        } else {
            order.setLocation("");
        }

        return order;
    }
}
