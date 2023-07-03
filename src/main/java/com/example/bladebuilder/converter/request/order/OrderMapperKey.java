package com.example.bladebuilder.converter.request.order;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderMapperKey {

    private final Integer idSeq;
    private final Integer seq;
    private final Integer customer;
    private final Integer description;
    private final Integer invoiceNumber;
    private final Integer thickness;
    private final Integer width;
    private final Integer location;
    private final Integer ordersElementsLength;
    private final String regex;

}
