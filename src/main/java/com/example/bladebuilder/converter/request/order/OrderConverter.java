package com.example.bladebuilder.converter.request.order;

import com.example.bladebuilder.model.entity.Order;
import org.springframework.core.convert.converter.Converter;

import java.util.Map;

public class OrderConverter implements Converter<Map<String, Object>, Order> {

    @Override
    public Order convert(Map<String, Object> ordersAndElementsIndex) {

        String[] orderSplit = ordersAndElementsIndex.get("orderToConvert").toString().split("\\\\t");

        OrderMapperKey elementsIndex = (OrderMapperKey) ordersAndElementsIndex.get("elementsIndex");

        return createNewOrder(orderSplit, elementsIndex);
    }

    private Order createNewOrder(String[] orderSplit, OrderMapperKey elementsIndex) {

        Order order = new Order();

        order.setIdSeq(Integer.parseInt(orderSplit[elementsIndex.getIdSeq() != null ?
                elementsIndex.getIdSeq() : 0]));

        order.setSeq(Integer.parseInt(orderSplit[elementsIndex.getSeq()].replaceAll(" ", "")));
        order.setCustomer(orderSplit[elementsIndex.getCustomer()]);
        order.setDescription(orderSplit[elementsIndex.getDescription()]);
        order.setInvoiceNumber(orderSplit[elementsIndex.getInvoiceNumber()]);
        order.setThickness(orderSplit[elementsIndex.getThickness()]);
        order.setWidth(orderSplit[elementsIndex.getWidth()]);

        order.setLocation(orderSplit.length >= elementsIndex.getOrdersElementsLength() ?
                orderSplit[elementsIndex.getLocation()] : "");

        return order;

    }
}
