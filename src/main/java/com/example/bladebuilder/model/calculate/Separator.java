package com.example.bladebuilder.model.calculate;

import com.example.bladebuilder.model.reguest.MeasurementRequestDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RequiredArgsConstructor
public class Separator implements CenterCalculator{

    private static final BigDecimal FULL_SHAFT_SIZE = new BigDecimal("1775");
    private static final BigDecimal CENTER_DIVIDER = new BigDecimal("2");
    private static final BigDecimal CORRECTION_FOR_CENTER_1 = new BigDecimal("4");
    private static final BigDecimal CORRECTION_FOR_CENTER_2 = new BigDecimal("35");
    private static final BigDecimal REDUCE_QUANTITY = BigDecimal.ONE;
    private final MeasurementRequestDTO measurementRequestDTO;
    @Getter
    private String center1;
    @Getter
    private String center2;

    @Override
    public void countCenter1() {center1 = countCenter(CORRECTION_FOR_CENTER_1);}

    @Override
    public void countCenter2() {center2 = countCenter(CORRECTION_FOR_CENTER_2);}

    private String countCenter(BigDecimal correction) {

        BigDecimal result = FULL_SHAFT_SIZE;

        result = result.subtract(measurementRequestDTO.getFullSize());
        result = result.subtract((measurementRequestDTO.getFullQuantity().subtract(REDUCE_QUANTITY)).multiply(correction));
        result = result.divide(CENTER_DIVIDER, 1, RoundingMode.HALF_EVEN);

        return String.valueOf(result);

    }

}
