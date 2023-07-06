package com.example.bladebuilder.order.request;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapperKeyService {

    private final List<OrderMapperKey> orderMapperKeyList = new ArrayList<>();

    public OrderMapperKeyService() {

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
                .regex("^(([\\d ]+\\\\t){2}\\d{4}-\\d{2}-\\d{2}\\\\t((.+)\\\\t){2}"
                        + "(.+)\\\\t([\\d ,]+\\\\t){3}([A-Za-z\\d]{0,4})?\\n?)+$")
                .build();

        OrderMapperKey secondRegex = OrderMapperKey.builder()
                .idSeq(0)
                .seq(5)
                .customer(6)
                .description(8)
                .invoiceNumber(7)
                .thickness(9)
                .width(10)
                .location(14)
                .ordersElementsLength(15)
                .regex("^(([\\d ]+\\\\t)((.+)\\\\t){3}\\d{4}-\\d{2}-\\d{2}\\\\t([\\d ]+\\\\t)"
                        + "(((.+)\\\\t)){3}([\\d ,]+\\\\t){2}(((.+)\\\\t)){3}([A-Za-z\\d]{0,4})?\\n?)+$")
                .build();

        orderMapperKeyList.add(firstRegex);
        orderMapperKeyList.add(secondRegex);

    }

    public List<OrderMapperKey> getOrderMapperKeyList() {
        return orderMapperKeyList;
    }
}
