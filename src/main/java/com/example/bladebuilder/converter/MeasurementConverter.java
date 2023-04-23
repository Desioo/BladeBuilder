package com.example.bladebuilder.converter;

import com.example.bladebuilder.model.calculate.Dimension;
import com.example.bladebuilder.model.entity.Measurement;
import com.example.bladebuilder.model.reguest.MeasurementRequestDTO;
import com.example.bladebuilder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;


public class MeasurementConverter implements Converter<MeasurementRequestDTO, Measurement> {

    @Autowired
    private UserService userService;

    @Override
    public Measurement convert(MeasurementRequestDTO requestDTO) {

        Measurement measurement = new Measurement();
        //TODO strefa czasowa
        ZonedDateTime warsawDateTime = ZonedDateTime.now(ZoneId.of("Europe/Warsaw"));

        measurement.setThickness(String.valueOf(requestDTO.getThickness()));
        measurement.setUser(userService.findUserPassword(requestDTO.getUserPassword()));
        measurement.setDimensionsWithQuantity(changeDimensionsToText(requestDTO.getDimensionsList()));
        measurement.setDate(warsawDateTime.toLocalDate());
        measurement.setTime(warsawDateTime.toLocalTime());

        return measurement;
    }

    private String changeDimensionsToText(List<Dimension> dimensions) {

        StringBuilder dimensionsWithQuantity = new StringBuilder();

        for (int i = 0; i < dimensions.size(); i++) {

            dimensionsWithQuantity.append(dimensions.get(i).getQuantity());
            dimensionsWithQuantity.append(" X ");
            dimensionsWithQuantity.append(dimensions.get(i).getSize());

            if (i < dimensions.size() - 1) {
                dimensionsWithQuantity.append(" + ");
            }
        }
        return dimensionsWithQuantity.toString();
    }
}
