package com.example.bladebuilder.model.calculation.knife;

import com.example.bladebuilder.model.calculation.Knife;
import com.example.bladebuilder.model.reguest.MeasurementRequestDTO;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class KnifeSizeSubtractionTest {

    @Test
    public void testSizeSubtraction_case1_CorrectCalculation() {

        //given
        BigDecimal expected = new BigDecimal("299.84");

        BigDecimal sizeValue = new BigDecimal("320");

        MeasurementRequestDTO measurementRequestDTO = new MeasurementRequestDTO();
        measurementRequestDTO.setKnivesSize(new BigDecimal("10"));
        measurementRequestDTO.setThickness(new BigDecimal("0.8"));

        Knife knife = new Knife(measurementRequestDTO);

        //when
        BigDecimal result = knife.subtractKnifeAndThicknessFromSize(sizeValue);

        //then
        assertEquals(expected, result);

    }
}
