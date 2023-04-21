package com.example.bladebuilder.converter;

import com.example.bladebuilder.model.entity.Order;
import org.springframework.core.convert.converter.Converter;

public class OrderConverter implements Converter<String, Order> {


    @Override
    public Order convert(String stringToConvert) {

        String[] orderSplit = stringToConvert.split("\\\\t");

        Order order = Order.builder()
                .idSeq(Integer.parseInt(orderSplit[0]))
                .seq(Integer.parseInt(orderSplit[1]))
                .customer(orderSplit[3])
                .description(orderSplit[4])
                .invoiceNumber(orderSplit[5])
                .thickness(orderSplit[6])
                .width(orderSplit[7])
                .build();

        if (orderSplit.length >= 11) {
            order.setLocation(orderSplit[10]);
        } else {
            order.setLocation("");
        }

        return order;

    }
}
