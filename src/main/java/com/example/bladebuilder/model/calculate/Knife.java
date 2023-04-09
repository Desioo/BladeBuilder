package com.example.bladebuilder.model.calculate;

import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;

public class Knife extends MeasurementDetails implements CenterCalculator {
    private static final BigDecimal FULL_SHAFT_SIZE = new BigDecimal("1740");
    private static final BigDecimal CENTER_DIVIDER = new BigDecimal("2");
    private static final BigDecimal DOUBLE = new BigDecimal("2");
    private static final BigDecimal KNIFE_CORRECTION = new BigDecimal("0.04");
    private static final BigDecimal TEN_PERCENT = new BigDecimal("0.1");

    @Setter
    private String center1;
    @Setter
    private List<String> center2;

    @Override
    public void countCenter1() {

        BigDecimal result = FULL_SHAFT_SIZE;

        result = result.subtract(getFullSize()).divide(CENTER_DIVIDER, 0, RoundingMode.HALF_EVEN);

        center1 = String.valueOf(result);
    }

    @Override
    public void countCenter2() {

        BigDecimal result = new BigDecimal(center1);

        result = result.subtract(getKnivesSize());
        result = result.subtract(getThickness().multiply(TEN_PERCENT));
        result = result.subtract(KNIFE_CORRECTION);
        result = result.setScale(2, RoundingMode.HALF_EVEN).stripTrailingZeros();

        center2 = Collections.singletonList(String.valueOf(result));

    }
}
