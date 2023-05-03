package com.example.bladebuilder.model.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class MeasurementResponseDTO {

    private long id;

    private LocalDate date;

    private LocalTime time;

    private BigDecimal thickness;

    private String dimensionsWithQuantity;

    private UserResponseDTO user;

}
