package com.example.bladebuilder.model.calculation.knife;

import com.example.bladebuilder.model.calculation.Knife;
import com.example.bladebuilder.model.reguest.MeasurementRequestDTO;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;


public class SizeToDistanceMapperTest {

    @Test
    public void testCalculateDistance_case1_CorrectCalculation() {

        //given
        List<BigDecimal> expected = new ArrayList<>();
        expected.add(new BigDecimal("175"));
        expected.add(new BigDecimal("3.9"));

        BigDecimal sizeValue = new BigDecimal("178.9");

        Knife knife = new Knife(new MeasurementRequestDTO());

        //when
        List<BigDecimal> result = knife.mapSizeToDistance(sizeValue);

        //then
        assertArrayEquals(expected.toArray(), result.toArray());

    }

}
