package com.example.bladebuilder.converter.response;

import com.example.bladebuilder.model.calculation.Knife;
import com.example.bladebuilder.model.calculation.Separator;
import com.example.bladebuilder.model.reguest.MeasurementRequestDTO;
import com.example.bladebuilder.model.response.MeasurementWithCalculationsDTO;
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
