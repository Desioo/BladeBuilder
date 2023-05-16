package com.example.bladebuilder.converter.entity;

import com.example.bladebuilder.model.entity.Measurement;
import com.example.bladebuilder.model.response.MeasurementResponseDTO;
import com.example.bladebuilder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


public class MeasurementConverter implements Converter<MeasurementResponseDTO, Measurement> {


    @Autowired
    private UserService userService;

    @Override
    public Measurement convert(MeasurementResponseDTO measurementResponseDTO) {

        Measurement measurement = new Measurement();

        measurement.setId(measurementResponseDTO.getId());
        measurement.setDate(measurementResponseDTO.getDate());
        measurement.setTime(measurementResponseDTO.getTime());
        measurement.setThickness(measurementResponseDTO.getThickness());
        measurement.setDimensionsWithQuantity(measurementResponseDTO.getDimensionsWithQuantity());
        measurement.setUser(userService.findById(measurementResponseDTO.getUser().getId()).get());

        return measurement;

    }
}
