package com.example.bladebuilder.converter;

import com.example.bladebuilder.model.calculate.Dimension;
import com.example.bladebuilder.model.entity.Measurement;
import com.example.bladebuilder.model.reguest.MeasurementRequestDTO;
import com.example.bladebuilder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class MeasurementConverter implements Converter<MeasurementRequestDTO, Measurement> {
    @Autowired
    private UserService userService;

    private final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    @Override
    public Measurement convert(MeasurementRequestDTO requestDTO) {

        Measurement measurement = new Measurement();

        measurement.setThickness(String.valueOf(requestDTO.getThickness()));
        measurement.setUserName(userService.getUserNameByPassword(requestDTO.getUserPassword()));
        measurement.setDimensionsWithQuantity(changeDimensionsToText(requestDTO.getDimensionsList()));
        measurement.setDate(LocalDate.now());
        measurement.setTime(LocalTime.now());

        return measurement;
    }

    private String changeDimensionsToText(List<Dimension> dimensions) {

        StringBuilder dimensionsWithQuantity = new StringBuilder();

        for (int i = 0; i < dimensions.size(); i++) {

            dimensionsWithQuantity.append(dimensions.get(i).getQuantity());
            dimensionsWithQuantity.append("X");
            dimensionsWithQuantity.append(dimensions.get(i).getSize());

            if (i < dimensions.size() - 1) {
                dimensionsWithQuantity.append(" + ");
            }
        }

        return dimensionsWithQuantity.toString();

    }

    private void setDataAndTime(Measurement measurement){

        LocalDateTime localDateTime = LocalDateTime.now();

        measurement.setDate(LocalDate.parse(localDateTime.format(DATE_FORMATTER), DATE_FORMATTER));
        measurement.setTime(LocalTime.parse(localDateTime.format(TIME_FORMATTER), TIME_FORMATTER));

    }

}
