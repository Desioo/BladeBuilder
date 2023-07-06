package com.example.bladebuilder.measurement.converter;

import com.example.bladebuilder.calculation.Dimension;
import com.example.bladebuilder.measurement.reguest.MeasurementRequestDTO;
import com.example.bladebuilder.measurement.response.MeasurementResponseDTO;
import com.example.bladebuilder.user.UserService;
import com.example.bladebuilder.user.UserResponseDTOConverter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class MeasurementResponseDTOConverter implements Converter<MeasurementRequestDTO, MeasurementResponseDTO> {

    @Autowired
    private UserResponseDTOConverter userResponseDTOConverter;

    @Autowired
    private UserService userService;

    @SneakyThrows
    @Override
    public MeasurementResponseDTO convert(MeasurementRequestDTO requestDTO) {

        MeasurementResponseDTO measurement = new MeasurementResponseDTO();
        //TODO strefa czasowa
        ZonedDateTime warsawDateTime = ZonedDateTime.now(ZoneId.of("Europe/Warsaw"));

        measurement.setThickness(requestDTO.getThickness());
        measurement.setUser(userResponseDTOConverter.convert(userService.findUserByPassword(requestDTO.getUserPassword())));
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
