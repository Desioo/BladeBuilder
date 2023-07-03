package com.example.bladebuilder.converter.request.order;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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
                .regex("^\"(([\\d ]+\\\\t){2}\\d{4}-\\d{2}-\\d{2}\\\\t((.+)\\\\t){2}"
                        + "(.+)\\\\t([\\d ,]+\\\\t){3}([A-Za-z\\d]{0,4})?\\n?)+\"$")
                .build();

        orderMapperKeyList.add(firstRegex);
    }

    public List<OrderMapperKey> getOrderMapperKeyList() {
        return orderMapperKeyList;
    }
}
