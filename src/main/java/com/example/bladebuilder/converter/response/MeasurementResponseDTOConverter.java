package com.example.bladebuilder.converter.response;

import com.example.bladebuilder.model.entity.Measurement;
import com.example.bladebuilder.model.response.MeasurementResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class MeasurementResponseDTOConverter implements Converter<Measurement, MeasurementResponseDTO> {

    @Autowired
    private UserResponseDTOConverter userResponseDTOConverter;

    @Override
    public MeasurementResponseDTO convert(Measurement measurement) {

        MeasurementResponseDTO measurementResponseDTO = new MeasurementResponseDTO();

        measurementResponseDTO.setId(measurement.getId());
        measurementResponseDTO.setDate(measurement.getDate());
        measurementResponseDTO.setTime(measurement.getTime());
        measurementResponseDTO.setThickness(measurement.getThickness());
        measurementResponseDTO.setDimensionsWithQuantity(measurement.getDimensionsWithQuantity());
        measurementResponseDTO.setUser(userResponseDTOConverter.convert(measurement.getUser()));

        return measurementResponseDTO;

    }
}
