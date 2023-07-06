package com.example.bladebuilder.measurement.converter;

import com.example.bladebuilder.measurement.MeasurementDetails;
import com.example.bladebuilder.measurement.reguest.MeasurementRequestDTO;
import org.springframework.core.convert.converter.Converter;

public class MeasurementDetailsConverter implements Converter<MeasurementRequestDTO, MeasurementDetails> {


    @Override
    public MeasurementDetails convert(MeasurementRequestDTO measurementRequestDTO) {

        MeasurementDetails measurementDetails = new MeasurementDetails();

        measurementDetails.setFullSize(measurementRequestDTO.getFullSize());
        measurementDetails.setScrap(measurementRequestDTO.getScrap());
        measurementDetails.setKnivesSize(measurementRequestDTO.getKnivesSize());

        return measurementDetails;

    }
}
