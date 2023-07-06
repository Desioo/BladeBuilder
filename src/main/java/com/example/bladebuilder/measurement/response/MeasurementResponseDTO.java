package com.example.bladebuilder.measurement.response;

import com.example.bladebuilder.user.UserResponseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class MeasurementResponseDTO {

    private long id;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate date;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime time;

    private BigDecimal thickness;

    private String dimensionsWithQuantity;

    private UserResponseDTO user;

}
