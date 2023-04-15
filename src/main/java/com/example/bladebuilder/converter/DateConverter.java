package com.example.bladebuilder.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;

public class DateConverter implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(String date) {
        return LocalDate.parse(date);
    }
}
