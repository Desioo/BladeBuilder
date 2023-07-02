package com.example.bladebuilder.converter.request;

import com.example.bladebuilder.model.entity.Order;
import org.springframework.core.convert.converter.Converter;

import java.util.Map;
import java.util.stream.Collectors;

public class OrderConverter implements Converter<Map<String, Map<String, Integer>>, Order> {

    @Override
    public Order convert(Map<String, Map<String, Integer>> ordersAndElementsIndex) {

        String orderToConvert = String.join("", ordersAndElementsIndex.keySet());

        String[] orderSplit = orderToConvert.split("\\\\t");

        Map<String, Integer> elementsIndex = ordersAndElementsIndex.get(orderToConvert);

        Order order = new Order();

        order.setIdSeq(Integer.parseInt(orderSplit[elementsIndex.get("idSeq") != null ?
                elementsIndex.get("idSeq") : 0]));

        order.setSeq(Integer.parseInt(orderSplit[elementsIndex.get("seq")].replaceAll(" ", "")));
        order.setCustomer(orderSplit[elementsIndex.get("customer")]);
        order.setDescription(orderSplit[elementsIndex.get("description")]);
        order.setInvoiceNumber(orderSplit[elementsIndex.get("invoiceNumber")]);
        order.setThickness(orderSplit[elementsIndex.get("thickness")]);
        order.setWidth(orderSplit[elementsIndex.get("width")]);

        order.setLocation(orderSplit.length >= elementsIndex.get("ordersElementsLength") ? orderSplit[elementsIndex.get("location")] : "");

        return order;
    }
}
