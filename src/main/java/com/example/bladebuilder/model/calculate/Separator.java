package com.example.bladebuilder.model.calculate;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Separator extends MeasurementDetails implements CenterCalculator{

    private static final BigDecimal FULL_SHAFT_SIZE = new BigDecimal("1775");
    private static final BigDecimal CENTER_DIVIDER = new BigDecimal("2");
    private static final BigDecimal CORRECTION_FOR_CENTER_1 = new BigDecimal("4");
    private static final BigDecimal CORRECTION_FOR_CENTER_2 = new BigDecimal("35");
    private static final BigDecimal REDUCE_QUANTITY = BigDecimal.ONE;

    @Getter
    private String center1;
    @Getter
    private String center2;


    public Separator(MeasurementDetails measurementDetails){
        this.setFullQuantity(measurementDetails.getFullQuantity());
        this.setFullSize(measurementDetails.getFullSize());
    }

    @Override
    public void countCenter1() {center1 = countCenter(CORRECTION_FOR_CENTER_1);}

    @Override
    public void countCenter2() {center2 = countCenter(CORRECTION_FOR_CENTER_2);}

    private String countCenter(BigDecimal correction) {

        BigDecimal result = FULL_SHAFT_SIZE;

        result = result.subtract(getFullSize());
        result = result.subtract((getFullQuantity().subtract(REDUCE_QUANTITY)).multiply(correction));
        result = result.divide(CENTER_DIVIDER, 1, RoundingMode.HALF_EVEN);

        return String.valueOf(result);

    }

}
