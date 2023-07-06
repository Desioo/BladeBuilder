package com.example.bladebuilder.model.calculation.knife;

import com.example.bladebuilder.calculation.Knife;
import com.example.bladebuilder.measurement.reguest.MeasurementRequestDTO;
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

    @Test
    public void testSizeSubtraction_case2_CorrectCalculation() {

        //given
        BigDecimal expected = new BigDecimal("199.76");

        BigDecimal sizeValue = new BigDecimal("220");

        MeasurementRequestDTO measurementRequestDTO = new MeasurementRequestDTO();
        measurementRequestDTO.setKnivesSize(new BigDecimal("10"));
        measurementRequestDTO.setThickness(new BigDecimal("1.2"));

        Knife knife = new Knife(measurementRequestDTO);

        //when
        BigDecimal result = knife.subtractKnifeAndThicknessFromSize(sizeValue);

        //then
        assertEquals(expected, result);

    }

    @Test
    public void testSizeSubtraction_case3_CorrectCalculation() {

        //given
        BigDecimal expected = new BigDecimal("213.4");

        BigDecimal sizeValue = new BigDecimal("254");

        MeasurementRequestDTO measurementRequestDTO = new MeasurementRequestDTO();
        measurementRequestDTO.setKnivesSize(new BigDecimal("20"));
        measurementRequestDTO.setThickness(new BigDecimal("3"));

        Knife knife = new Knife(measurementRequestDTO);

        //when
        BigDecimal result = knife.subtractKnifeAndThicknessFromSize(sizeValue);

        //then
        assertEquals(expected, result);

    }

    @Test
    public void testSizeSubtraction_case4_CorrectCalculation() {

        //given
        BigDecimal expected = new BigDecimal("449.68");

        BigDecimal sizeValue = new BigDecimal("470");

        MeasurementRequestDTO measurementRequestDTO = new MeasurementRequestDTO();
        measurementRequestDTO.setKnivesSize(new BigDecimal("10"));
        measurementRequestDTO.setThickness(new BigDecimal("1.6"));

        Knife knife = new Knife(measurementRequestDTO);

        //when
        BigDecimal result = knife.subtractKnifeAndThicknessFromSize(sizeValue);

        //then
        assertEquals(expected, result);

    }

    @Test
    public void testSizeSubtraction_case5_CorrectCalculation() {

        //given
        BigDecimal expected = new BigDecimal("316.90");

        BigDecimal sizeValue = new BigDecimal("337");

        MeasurementRequestDTO measurementRequestDTO = new MeasurementRequestDTO();
        measurementRequestDTO.setKnivesSize(new BigDecimal("10"));
        measurementRequestDTO.setThickness(new BigDecimal("0.5"));

        Knife knife = new Knife(measurementRequestDTO);

        //when
        BigDecimal result = knife.subtractKnifeAndThicknessFromSize(sizeValue);

        //then
        assertEquals(expected, result);

    }

    @Test
    public void testSizeSubtraction_case6_CorrectCalculation() {

        //given
        BigDecimal expected = new BigDecimal("214.84");

        BigDecimal sizeValue = new BigDecimal("235");

        MeasurementRequestDTO measurementRequestDTO = new MeasurementRequestDTO();
        measurementRequestDTO.setKnivesSize(new BigDecimal("10"));
        measurementRequestDTO.setThickness(new BigDecimal("0.8"));

        Knife knife = new Knife(measurementRequestDTO);

        //when
        BigDecimal result = knife.subtractKnifeAndThicknessFromSize(sizeValue);

        //then
        assertEquals(expected, result);

    }

    @Test
    public void testSizeSubtraction_case7_CorrectCalculation() {

        //given
        BigDecimal expected = new BigDecimal("414.40");

        BigDecimal sizeValue = new BigDecimal("434.5");

        MeasurementRequestDTO measurementRequestDTO = new MeasurementRequestDTO();
        measurementRequestDTO.setKnivesSize(new BigDecimal("10"));
        measurementRequestDTO.setThickness(new BigDecimal("0.5"));

        Knife knife = new Knife(measurementRequestDTO);

        //when
        BigDecimal result = knife.subtractKnifeAndThicknessFromSize(sizeValue);

        //then
        assertEquals(expected, result);

    }

    @Test
    public void testSizeSubtraction_case8_CorrectCalculation() {

        //given
        BigDecimal expected = new BigDecimal("390.08");

        BigDecimal sizeValue = new BigDecimal("410.2");

        MeasurementRequestDTO measurementRequestDTO = new MeasurementRequestDTO();
        measurementRequestDTO.setKnivesSize(new BigDecimal("10"));
        measurementRequestDTO.setThickness(new BigDecimal("0.6"));

        Knife knife = new Knife(measurementRequestDTO);

        //when
        BigDecimal result = knife.subtractKnifeAndThicknessFromSize(sizeValue);

        //then
        assertEquals(expected, result);

    }

    @Test
    public void testSizeSubtraction_case9_CorrectCalculation() {

        //given
        BigDecimal expected = new BigDecimal("82.90");

        BigDecimal sizeValue = new BigDecimal("103");

        MeasurementRequestDTO measurementRequestDTO = new MeasurementRequestDTO();
        measurementRequestDTO.setKnivesSize(new BigDecimal("10"));
        measurementRequestDTO.setThickness(new BigDecimal("0.5"));

        Knife knife = new Knife(measurementRequestDTO);

        //when
        BigDecimal result = knife.subtractKnifeAndThicknessFromSize(sizeValue);

        //then
        assertEquals(expected, result);

    }

    @Test
    public void testSizeSubtraction_case10_CorrectCalculation() {

        //given
        BigDecimal expected = new BigDecimal("29.36");

        BigDecimal sizeValue = new BigDecimal("70");

        MeasurementRequestDTO measurementRequestDTO = new MeasurementRequestDTO();
        measurementRequestDTO.setKnivesSize(new BigDecimal("20"));
        measurementRequestDTO.setThickness(new BigDecimal("3.2"));

        Knife knife = new Knife(measurementRequestDTO);

        //when
        BigDecimal result = knife.subtractKnifeAndThicknessFromSize(sizeValue);

        //then
        assertEquals(expected, result);

    }

    @Test
    public void testSizeSubtraction_case11_CorrectCalculation() {

        //given
        BigDecimal expected = new BigDecimal("1173.68");

        BigDecimal sizeValue = new BigDecimal("1194");

        MeasurementRequestDTO measurementRequestDTO = new MeasurementRequestDTO();
        measurementRequestDTO.setKnivesSize(new BigDecimal("10"));
        measurementRequestDTO.setThickness(new BigDecimal("1.6"));

        Knife knife = new Knife(measurementRequestDTO);

        //when
        BigDecimal result = knife.subtractKnifeAndThicknessFromSize(sizeValue);

        //then
        assertEquals(expected, result);

    }

    @Test
    public void testSizeSubtraction_case12_CorrectCalculation() {

        //given
        BigDecimal expected = new BigDecimal("179.76");

        BigDecimal sizeValue = new BigDecimal("200");

        MeasurementRequestDTO measurementRequestDTO = new MeasurementRequestDTO();
        measurementRequestDTO.setKnivesSize(new BigDecimal("10"));
        measurementRequestDTO.setThickness(new BigDecimal("1.2"));

        Knife knife = new Knife(measurementRequestDTO);

        //when
        BigDecimal result = knife.subtractKnifeAndThicknessFromSize(sizeValue);

        //then
        assertEquals(expected, result);

    }

    @Test
    public void testSizeSubtraction_case13_CorrectCalculation() {

        //given
        BigDecimal expected = new BigDecimal("159.48");

        BigDecimal sizeValue = new BigDecimal("200");

        MeasurementRequestDTO measurementRequestDTO = new MeasurementRequestDTO();
        measurementRequestDTO.setKnivesSize(new BigDecimal("20"));
        measurementRequestDTO.setThickness(new BigDecimal("2.6"));

        Knife knife = new Knife(measurementRequestDTO);

        //when
        BigDecimal result = knife.subtractKnifeAndThicknessFromSize(sizeValue);

        //then
        assertEquals(expected, result);

    }

    @Test
    public void testSizeSubtraction_case14_CorrectCalculation() {

        //given
        BigDecimal expected = new BigDecimal("89.54");

        BigDecimal sizeValue = new BigDecimal("130");

        MeasurementRequestDTO measurementRequestDTO = new MeasurementRequestDTO();
        measurementRequestDTO.setKnivesSize(new BigDecimal("20"));
        measurementRequestDTO.setThickness(new BigDecimal("2.3"));

        Knife knife = new Knife(measurementRequestDTO);

        //when
        BigDecimal result = knife.subtractKnifeAndThicknessFromSize(sizeValue);

        //then
        assertEquals(expected, result);

    }

    @Test
    public void testSizeSubtraction_case15_CorrectCalculation() {

        //given
        BigDecimal expected = new BigDecimal("239.76");

        BigDecimal sizeValue = new BigDecimal("260");

        MeasurementRequestDTO measurementRequestDTO = new MeasurementRequestDTO();
        measurementRequestDTO.setKnivesSize(new BigDecimal("10"));
        measurementRequestDTO.setThickness(new BigDecimal("1.2"));

        Knife knife = new Knife(measurementRequestDTO);

        //when
        BigDecimal result = knife.subtractKnifeAndThicknessFromSize(sizeValue);

        //then
        assertEquals(expected, result);

    }

    @Test
    public void testSizeSubtraction_case16_CorrectCalculation() {

        //given
        BigDecimal expected = new BigDecimal("142.02");

        BigDecimal sizeValue = new BigDecimal("162.1");

        MeasurementRequestDTO measurementRequestDTO = new MeasurementRequestDTO();
        measurementRequestDTO.setKnivesSize(new BigDecimal("10"));
        measurementRequestDTO.setThickness(new BigDecimal("0.4"));

        Knife knife = new Knife(measurementRequestDTO);

        //when
        BigDecimal result = knife.subtractKnifeAndThicknessFromSize(sizeValue);

        //then
        assertEquals(expected, result);

    }

    @Test
    public void testSizeSubtraction_case17_CorrectCalculation() {

        //given
        BigDecimal expected = new BigDecimal("186.08");

        BigDecimal sizeValue = new BigDecimal("206.2");

        MeasurementRequestDTO measurementRequestDTO = new MeasurementRequestDTO();
        measurementRequestDTO.setKnivesSize(new BigDecimal("10"));
        measurementRequestDTO.setThickness(new BigDecimal("0.6"));

        Knife knife = new Knife(measurementRequestDTO);

        //when
        BigDecimal result = knife.subtractKnifeAndThicknessFromSize(sizeValue);

        //then
        assertEquals(expected, result);

    }

    @Test
    public void testSizeSubtraction_case18_CorrectCalculation() {

        //given
        BigDecimal expected = new BigDecimal("480.18");

        BigDecimal sizeValue = new BigDecimal("500.3");

        MeasurementRequestDTO measurementRequestDTO = new MeasurementRequestDTO();
        measurementRequestDTO.setKnivesSize(new BigDecimal("10"));
        measurementRequestDTO.setThickness(new BigDecimal("0.6"));

        Knife knife = new Knife(measurementRequestDTO);

        //when
        BigDecimal result = knife.subtractKnifeAndThicknessFromSize(sizeValue);

        //then
        assertEquals(expected, result);

    }

    @Test
    public void testSizeSubtraction_case19_CorrectCalculation() {

        //given
        BigDecimal expected = new BigDecimal("320.18");

        BigDecimal sizeValue = new BigDecimal("340.3");

        MeasurementRequestDTO measurementRequestDTO = new MeasurementRequestDTO();
        measurementRequestDTO.setKnivesSize(new BigDecimal("10"));
        measurementRequestDTO.setThickness(new BigDecimal("0.6"));

        Knife knife = new Knife(measurementRequestDTO);

        //when
        BigDecimal result = knife.subtractKnifeAndThicknessFromSize(sizeValue);

        //then
        assertEquals(expected, result);

    }

    @Test
    public void testSizeSubtraction_case20_CorrectCalculation() {

        //given
        BigDecimal expected = new BigDecimal("664.14");

        BigDecimal sizeValue = new BigDecimal("684.3");

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
