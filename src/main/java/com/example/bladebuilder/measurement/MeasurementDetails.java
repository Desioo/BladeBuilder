package com.example.bladebuilder.measurement;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MeasurementDetails {

    private BigDecimal fullSize;
    private BigDecimal scrap;
    private BigDecimal knivesSize;

}
