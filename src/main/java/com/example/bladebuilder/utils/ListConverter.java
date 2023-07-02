package com.example.bladebuilder.utils;

import org.springframework.core.convert.converter.Converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListConverter {

    public static <A, B> List<B> convertList(List<A> list, Converter<A, B> converter){
      return list.stream()
                .map(converter::convert).collect(Collectors.toList());
    }

    public static <A, B> List<B> convertArrayToList(A[] list, Converter<A, B> converter){
        return Arrays.stream(list)
                .map(converter::convert).collect(Collectors.toList());
    }

}