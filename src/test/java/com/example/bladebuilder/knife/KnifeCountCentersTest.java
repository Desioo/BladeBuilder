package com.example.bladebuilder.knife;

import com.example.bladebuilder.model.calculation.Dimension;
import com.example.bladebuilder.model.calculation.Knife;
import com.example.bladebuilder.model.reguest.MeasurementRequestDTO;
import lombok.SneakyThrows;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class KnifeCountCentersTest {

    @SneakyThrows
    private void createAllAndCheckResult(BigDecimal centerBottom,
                                         List<BigDecimal> centerTop, BigDecimal thickness,
                                         BigDecimal knifeSize, List<Dimension> dimensions) {

        // given
        MeasurementRequestDTO measurementRequestDTO = new MeasurementRequestDTO();
        measurementRequestDTO.setDimensionsList(dimensions);
        measurementRequestDTO.setThickness(thickness);
        measurementRequestDTO.setKnivesSize(knifeSize);
        measurementRequestDTO.countSizeQuantityAndScrap();

        Knife knife = new Knife(measurementRequestDTO);

        // when
        knife.countCenter2();
        knife.countCenter1();

        BigDecimal centerBottomResult = knife.getCenterBottom();
        List<BigDecimal> centerTopResult = knife.getCenterTop();

        // then
        assertEquals(centerBottom, centerBottomResult);
        assertEquals(centerTop, centerTopResult);

    }


    @Test
    public void testCountCenters_case1() {

        // given
        BigDecimal centerBottom = new BigDecimal("279");

        List<BigDecimal> centerTop = new ArrayList<>();
        centerTop.add(new BigDecimal("260"));
        centerTop.add(new BigDecimal("3.9"));
        centerTop.add(new BigDecimal("5.01"));

        BigDecimal thickness = new BigDecimal("0.5");
        BigDecimal knifeSize = new BigDecimal("10");

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("2", "362.4"));
        dimensions.add(new Dimension("1", "257"));
        dimensions.add(new Dimension("1", "199"));

        createAllAndCheckResult(centerBottom, centerTop, thickness, knifeSize, dimensions);

    }

    @Test
    public void testCountCenters_case2() {

        // given
        BigDecimal centerBottom = new BigDecimal("130");

        List<BigDecimal> centerTop = new ArrayList<>();
        centerTop.add(new BigDecimal("106"));
        centerTop.add(new BigDecimal("3.8"));

        BigDecimal thickness = new BigDecimal("1.6");
        BigDecimal knifeSize = new BigDecimal("20");

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("4", "370"));

        createAllAndCheckResult(centerBottom, centerTop, thickness, knifeSize, dimensions);
    }

    @Test
    public void testCountCenters_case3() {

        // given
        BigDecimal centerBottom = new BigDecimal("280");

        List<BigDecimal> centerTop = new ArrayList<>();
        centerTop.add(new BigDecimal("266"));
        centerTop.add(new BigDecimal("3.9"));

        BigDecimal thickness = new BigDecimal("0.6");
        BigDecimal knifeSize = new BigDecimal("10");

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "275.1"));
        dimensions.add(new Dimension("4", "226.1"));

        createAllAndCheckResult(centerBottom, centerTop, thickness, knifeSize, dimensions);
    }

    @Test
    public void testCountCenters_case4() {

        // given
        BigDecimal centerBottom = new BigDecimal("210");

        List<BigDecimal> centerTop = new ArrayList<>();
        centerTop.add(new BigDecimal("191"));
        centerTop.add(new BigDecimal("3.8"));
        centerTop.add(new BigDecimal("5.04"));

        BigDecimal thickness = new BigDecimal("1.2");
        BigDecimal knifeSize = new BigDecimal("10");

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("6", "220"));

        createAllAndCheckResult(centerBottom, centerTop, thickness, knifeSize, dimensions);
    }

    @Test
    public void testCountCenters_case5() {

        // given
        BigDecimal centerBottom = new BigDecimal("235");

        List<BigDecimal> centerTop = new ArrayList<>();
        centerTop.add(new BigDecimal("206"));
        centerTop.add(new BigDecimal("3.6"));
        centerTop.add(new BigDecimal("5.06"));

        BigDecimal thickness = new BigDecimal("3");
        BigDecimal knifeSize = new BigDecimal("20");

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("5", "254"));

        createAllAndCheckResult(centerBottom, centerTop, thickness, knifeSize, dimensions);
    }

    @Test
    public void testCountCenters_case6() {
        // given
        BigDecimal centerBottom = new BigDecimal("215");

        List<BigDecimal> centerTop = new ArrayList<>();
        centerTop.add(new BigDecimal("201"));
        centerTop.add(new BigDecimal("3.8"));

        BigDecimal thickness = new BigDecimal("1.6");
        BigDecimal knifeSize = new BigDecimal("10");

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("2", "470"));
        dimensions.add(new Dimension("1", "370"));

        createAllAndCheckResult(centerBottom, centerTop, thickness, knifeSize, dimensions);
    }

    @Test
    public void testCountCenters_case7() {
        // given
        BigDecimal centerBottom = new BigDecimal("271");

        List<BigDecimal> centerTop = new ArrayList<>();
        centerTop.add(new BigDecimal("252"));
        centerTop.add(new BigDecimal("3.9"));
        centerTop.add(new BigDecimal("5.01"));

        BigDecimal thickness = new BigDecimal("0.5");
        BigDecimal knifeSize = new BigDecimal("10");

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("3", "122"));
        dimensions.add(new Dimension("3", "103"));
        dimensions.add(new Dimension("3", "108"));
        dimensions.add(new Dimension("3", "66"));

        createAllAndCheckResult(centerBottom, centerTop, thickness, knifeSize, dimensions);
    }

    @Test
    public void testCountCenters_case8() {
        // given
        BigDecimal centerBottom = new BigDecimal("364");

        List<BigDecimal> centerTop = new ArrayList<>();
        centerTop.add(new BigDecimal("345"));
        centerTop.add(new BigDecimal("3.9"));
        centerTop.add(new BigDecimal("5.01"));

        BigDecimal thickness = new BigDecimal("0.5");
        BigDecimal knifeSize = new BigDecimal("10");

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("3", "337"));

        createAllAndCheckResult(centerBottom, centerTop, thickness, knifeSize, dimensions);
    }

    @Test
    public void testCountCenters_case9() {
        // given
        BigDecimal centerBottom = new BigDecimal("400");

        List<BigDecimal> centerTop = new ArrayList<>();
        centerTop.add(new BigDecimal("381"));
        centerTop.add(new BigDecimal("3.8"));
        centerTop.add(new BigDecimal("5.08"));

        BigDecimal thickness = new BigDecimal("0.8");
        BigDecimal knifeSize = new BigDecimal("10");

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("4", "235"));

        createAllAndCheckResult(centerBottom, centerTop, thickness, knifeSize, dimensions);
    }

    @Test
    public void testCountCenters_case10() {
        // given
        BigDecimal centerBottom = new BigDecimal("255");

        List<BigDecimal> centerTop = new ArrayList<>();
        centerTop.add(new BigDecimal("236"));
        centerTop.add(new BigDecimal("3.9"));

        BigDecimal thickness = new BigDecimal("0.5");
        BigDecimal knifeSize = new BigDecimal("10");

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("2", "434.5"));
        dimensions.add(new Dimension("3", "120"));

        createAllAndCheckResult(centerBottom, centerTop, thickness, knifeSize, dimensions);
    }

    @Test
    public void testCountCenters_case11() {
        // given
        BigDecimal centerBottom = new BigDecimal("284");

        List<BigDecimal> centerTop = new ArrayList<>();
        centerTop.add(new BigDecimal("265"));
        centerTop.add(new BigDecimal("3.9"));

        BigDecimal thickness = new BigDecimal("0.5");
        BigDecimal knifeSize = new BigDecimal("10");

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("4", "133.9"));
        dimensions.add(new Dimension("1", "98.9"));
        dimensions.add(new Dimension("4", "133.9"));

        createAllAndCheckResult(centerBottom, centerTop, thickness, knifeSize, dimensions);
    }

    @Test
    public void testCountCenters_case12() {
        // given
        BigDecimal centerBottom = new BigDecimal("273");

        List<BigDecimal> centerTop = new ArrayList<>();
        centerTop.add(new BigDecimal("259"));
        centerTop.add(new BigDecimal("3.9"));

        BigDecimal thickness = new BigDecimal("0.6");
        BigDecimal knifeSize = new BigDecimal("10");

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "410.2"));
        dimensions.add(new Dimension("1", "375.2"));
        dimensions.add(new Dimension("2", "204.1"));

        createAllAndCheckResult(centerBottom, centerTop, thickness, knifeSize, dimensions);
    }

    @Test
    public void testCountCenters_case13() {
        // given
        BigDecimal centerBottom = new BigDecimal("271");

        List<BigDecimal> centerTop = new ArrayList<>();
        centerTop.add(new BigDecimal("252"));
        centerTop.add(new BigDecimal("3.9"));

        BigDecimal thickness = new BigDecimal("0.5");
        BigDecimal knifeSize = new BigDecimal("10");

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "690.2"));
        dimensions.add(new Dimension("1", "506.2"));

        createAllAndCheckResult(centerBottom, centerTop, thickness, knifeSize, dimensions);
    }

    @Test
    public void testCountCenters_case14() {
        // given
        BigDecimal centerBottom = new BigDecimal("272");

        List<BigDecimal> centerTop = new ArrayList<>();
        centerTop.add(new BigDecimal("253"));
        centerTop.add(new BigDecimal("3.9"));
        centerTop.add(new BigDecimal("5.01"));

        BigDecimal thickness = new BigDecimal("0.5");
        BigDecimal knifeSize = new BigDecimal("10");

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("2", "225"));
        dimensions.add(new Dimension("5", "108"));
        dimensions.add(new Dimension("2", "103"));

        createAllAndCheckResult(centerBottom, centerTop, thickness, knifeSize, dimensions);
    }

    @Test
    public void testCountCenters_case15() {
        // given
        BigDecimal centerBottom = new BigDecimal("130");

        List<BigDecimal> centerTop = new ArrayList<>();
        centerTop.add(new BigDecimal("111"));
        centerTop.add(new BigDecimal("3.8"));
        centerTop.add(new BigDecimal("5.08"));

        BigDecimal thickness = new BigDecimal("0.8");
        BigDecimal knifeSize = new BigDecimal("10");

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "1030"));
        dimensions.add(new Dimension("1", "305"));
        dimensions.add(new Dimension("1", "145"));

        createAllAndCheckResult(centerBottom, centerTop, thickness, knifeSize, dimensions);
    }

    @Test
    public void testCountCenters_case16() {
        // given
        BigDecimal centerBottom = new BigDecimal("120");

        List<BigDecimal> centerTop = new ArrayList<>();
        centerTop.add(new BigDecimal("101"));
        centerTop.add(new BigDecimal("3.7"));
        centerTop.add(new BigDecimal("5.06"));

        BigDecimal thickness = new BigDecimal("2");
        BigDecimal knifeSize = new BigDecimal("10");

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "370"));
        dimensions.add(new Dimension("2", "245"));
        dimensions.add(new Dimension("1", "215.5"));
        dimensions.add(new Dimension("2", "212"));

        createAllAndCheckResult(centerBottom, centerTop, thickness, knifeSize, dimensions);
    }

    @Test
    public void testCountCenters_case17() {
        // given
        BigDecimal centerBottom = new BigDecimal("310");

        List<BigDecimal> centerTop = new ArrayList<>();
        centerTop.add(new BigDecimal("281"));
        centerTop.add(new BigDecimal("3.6"));
        centerTop.add(new BigDecimal("5.04"));

        BigDecimal thickness = new BigDecimal("3.2");
        BigDecimal knifeSize = new BigDecimal("20");

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("16", "70"));

        createAllAndCheckResult(centerBottom, centerTop, thickness, knifeSize, dimensions);
    }

    @Test
    public void testCountCenters_case18() {
        // given
        BigDecimal centerBottom = new BigDecimal("273");

        List<BigDecimal> centerTop = new ArrayList<>();
        centerTop.add(new BigDecimal("259"));
        centerTop.add(new BigDecimal("3.8"));

        BigDecimal thickness = new BigDecimal("1.6");
        BigDecimal knifeSize = new BigDecimal("10");

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "1194"));

        createAllAndCheckResult(centerBottom, centerTop, thickness, knifeSize, dimensions);
    }

    @Test
    public void testCountCenters_case19() {

        // given
        BigDecimal centerBottom = new BigDecimal("240");

        List<BigDecimal> centerTop = new ArrayList<>();
        centerTop.add(new BigDecimal("221"));
        centerTop.add(new BigDecimal("3.8"));
        centerTop.add(new BigDecimal("5.04"));

        BigDecimal thickness = new BigDecimal("1.2");
        BigDecimal knifeSize = new BigDecimal("10");

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("3", "220"));
        dimensions.add(new Dimension("3", "200"));

        createAllAndCheckResult(centerBottom, centerTop, thickness, knifeSize, dimensions);
    }

    @Test
    public void testCountCenters_case20() {

        // given
        BigDecimal centerBottom = new BigDecimal("120");

        List<BigDecimal> centerTop = new ArrayList<>();
        centerTop.add(new BigDecimal("101"));
        centerTop.add(new BigDecimal("3.7"));
        centerTop.add(new BigDecimal("5.06"));

        BigDecimal thickness = new BigDecimal("2");
        BigDecimal knifeSize = new BigDecimal("10");

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "370"));
        dimensions.add(new Dimension("2", "245"));
        dimensions.add(new Dimension("1", "215.5"));
        dimensions.add(new Dimension("2", "212"));

        createAllAndCheckResult(centerBottom, centerTop, thickness, knifeSize, dimensions);
    }

//    @Test
//    public void testCountCenters_case21() {
//
//        // given
//        BigDecimal centerBottom = new BigDecimal("310");
//
//        List<BigDecimal> centerTop = new ArrayList<>();
//        centerTop.add(new BigDecimal("281"));
//        centerTop.add(new BigDecimal("3.6"));
//        centerTop.add(new BigDecimal("5.04"));
//
//        BigDecimal thickness = new BigDecimal("3.2");
//        BigDecimal knifeSize = new BigDecimal("10");
//
//        List<Dimension> dimensions = new ArrayList<>();
//        dimensions.add(new Dimension("16", "70"));
//
//        createAllAndCheckResult(centerBottom, centerTop, thickness, knifeSize, dimensions);
//    }

    @Test
    public void testCountCenters_case22() {

        // given
        BigDecimal centerBottom = new BigDecimal("273");

        List<BigDecimal> centerTop = new ArrayList<>();
        centerTop.add(new BigDecimal("259"));
        centerTop.add(new BigDecimal("3.8"));

        BigDecimal thickness = new BigDecimal("1.6");
        BigDecimal knifeSize = new BigDecimal("10");

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "1194"));

        createAllAndCheckResult(centerBottom, centerTop, thickness, knifeSize, dimensions);
    }

    @Test
    public void testCountCenters_case23() {

        // given
        BigDecimal centerBottom = new BigDecimal("240");

        List<BigDecimal> centerTop = new ArrayList<>();
        centerTop.add(new BigDecimal("221"));
        centerTop.add(new BigDecimal("3.8"));
        centerTop.add(new BigDecimal("5.04"));

        BigDecimal thickness = new BigDecimal("1.2");
        BigDecimal knifeSize = new BigDecimal("10");

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("3", "220"));
        dimensions.add(new Dimension("3", "200"));

        createAllAndCheckResult(centerBottom, centerTop, thickness, knifeSize, dimensions);
    }

    @Test
    public void testCountCenters_case24() {

        // given
        BigDecimal centerBottom = new BigDecimal("252");

        List<BigDecimal> centerTop = new ArrayList<>();
        centerTop.add(new BigDecimal("238"));
        centerTop.add(new BigDecimal("3.8"));

        BigDecimal thickness = new BigDecimal("1.6");
        BigDecimal knifeSize = new BigDecimal("10");

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "320"));
        dimensions.add(new Dimension("2", "315"));
        dimensions.add(new Dimension("1", "187"));
        dimensions.add(new Dimension("1", "99"));

        createAllAndCheckResult(centerBottom, centerTop, thickness, knifeSize, dimensions);
    }
}
