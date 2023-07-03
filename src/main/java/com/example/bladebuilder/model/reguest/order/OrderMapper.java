package com.example.bladebuilder.model.reguest.order;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {

    private final List<OrderMapperKey> orderMapperKeyList = new ArrayList<>();

    public OrderMapper() {

        OrderMapperKey firstRegex = OrderMapperKey.builder()
                .idSeq(0)
                .seq(1)
                .customer(3)
                .description(4)
                .invoiceNumber(5)
                .thickness(6)
                .width(7)
                .location(10)
                .ordersElementsLength(11)
                .regex("^\"(([\\d ]+\\\\t){2}\\d{4}-\\d{2}-\\d{2}\\\\t((.+)\\\\t){2}"
                        + "(.+)\\\\t([\\d ,]+\\\\t){3}([A-Za-z\\d]{0,4})?\\n?)+\"$")
                .build();

        orderMapperKeyList.add(firstRegex);
    }

    public List<OrderMapperKey> getOrderMapperKeyList() {
        return orderMapperKeyList;
    }
}
