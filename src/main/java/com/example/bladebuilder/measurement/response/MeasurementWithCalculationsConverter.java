package com.example.bladebuilder.measurement.response;

import com.example.bladebuilder.calculation.Knife;
import com.example.bladebuilder.calculation.Separator;
import com.example.bladebuilder.measurement.reguest.MeasurementRequestDTO;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class MeasurementWithCalculationsConverter implements Converter<MeasurementRequestDTO, MeasurementWithCalculationsDTO> {


    @Autowired
    private MeasurementDetailsConverter measurementDetailsConverter;

    @Autowired
    private MeasurementResponseDTOConverter measurementResponseDTOConverter;

    @SneakyThrows
    @Override
    public MeasurementWithCalculationsDTO convert(MeasurementRequestDTO measurementRequestDTO) {

        measurementRequestDTO.countSizeQuantityAndScrap();

        MeasurementWithCalculationsDTO measurementWithCalculationsDTO = new MeasurementWithCalculationsDTO();

        measurementWithCalculationsDTO
                .setMeasurement(measurementResponseDTOConverter.convert(measurementRequestDTO));

        measurementWithCalculationsDTO
                .setMeasurementDetails(measurementDetailsConverter.convert(measurementRequestDTO));

        measurementWithCalculationsDTO.setKnife(new Knife(measurementRequestDTO));
        measurementWithCalculationsDTO.setSeparator(new Separator(measurementRequestDTO));

        return measurementWithCalculationsDTO;

    }
}
