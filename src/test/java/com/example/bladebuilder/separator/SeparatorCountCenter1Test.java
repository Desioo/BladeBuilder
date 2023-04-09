package com.example.bladebuilder.separator;

import com.example.bladebuilder.model.calculate.Dimension;
import com.example.bladebuilder.model.calculate.MeasurementDetails;
import com.example.bladebuilder.model.calculate.Separator;
import com.example.bladebuilder.model.response.MeasurementWithCalculationsDTO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SeparatorCountCenter1Test {

    @Test
    public void testCountCenter1_case1() {

        // given

        String expected = "411.5";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("4", "235"));

        MeasurementDetails measurementDetails = new MeasurementDetails();
        measurementDetails.setDimensionsList(dimensions);

        // when

        measurementDetails.countFullSizeAndFullQuantity();
        Separator separator = new Separator(measurementDetails);
        separator.countCenter1();
        String result = separator.getCenter1();

        // then

        assertEquals(expected, result);

    }


//    @Test
//    public void testCountCenter1_case2() {
//
//        String expected = "247.5";
//        List<BigDecimal> quantities = List.of(new BigDecimal("3"), new BigDecimal("3"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("220"), new BigDecimal("200"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//
//        separator.countCenter1();
//        String result = separator.getCenter1();
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCountCenter1_case3() {
//
//        String expected = "770.0";
//        List<BigDecimal> quantities = List.of(new BigDecimal("1"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("235"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        separator.countCenter1();
//        String result = separator.getCenter1();
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCountCenter1_case4() {
//
//        String expected = "135.5";
//        List<BigDecimal> quantities = List.of(new BigDecimal("1"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("1504"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//
//        separator.countCenter1();
//        String result = separator.getCenter1();
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCountCenter1_case5() {
//
//        String expected = "277.5";
//        List<BigDecimal> quantities = List.of(new BigDecimal("6"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("200"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//
//        separator.countCenter1();
//        String result = separator.getCenter1();
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCountCenter1_case6() {
//
//        String expected = "289.8";
//        List<BigDecimal> quantities = List.of(new BigDecimal("1"), new BigDecimal("4"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("275.1"), new BigDecimal("226.1"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        separator.countCenter1();
//        String result = separator.getCenter1();
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCountCenter1_case7() {
//        BigDecimal expected = new BigDecimal("286.4");
//        List<BigDecimal> quantities = List.of(new BigDecimal("4"), new BigDecimal("1"), new BigDecimal("4"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("133.9"), new BigDecimal("98.9"), new BigDecimal("133.9"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        separator.countCenter1();
//        String result = separator.getCenter1();
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCountCenter1_case8() {
//        BigDecimal expected = new BigDecimal("273.5");
//        List<BigDecimal> quantities = List.of(new BigDecimal("2"), new BigDecimal("5"), new BigDecimal("2"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("225"), new BigDecimal("108"), new BigDecimal("103"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        separator.countCenter1();
//        String result = separator.getCenter1();
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCountCenter1_case9() {
//        BigDecimal expected = new BigDecimal("403.5");
//        List<BigDecimal> quantities = List.of(new BigDecimal("3"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("320"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        separator.countCenter1();
//        String result = separator.getCenter1();
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCountCenter1_case10() {
//        BigDecimal expected = new BigDecimal("287.1");
//        List<BigDecimal> quantities = List.of(new BigDecimal("3"), new BigDecimal("1"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("335.2"), new BigDecimal("183.1"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        separator.countCenter1();
//        String result = separator.getCenter1();
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCountCenter1_cas11() {
//        BigDecimal expected = new BigDecimal("141.5");
//        List<BigDecimal> quantities = List.of(new BigDecimal("4"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("370"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        separator.countCenter1();
//        String result = separator.getCenter1();
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCountCenter1_case12() {
//        BigDecimal expected = new BigDecimal("279.0");
//        List<BigDecimal> quantities = List.of(new BigDecimal("1"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("1217"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        separator.countCenter1();
//        String result = separator.getCenter1();
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCountCenter1_case13() {
//        BigDecimal expected = new BigDecimal("244.5");
//        List<BigDecimal> quantities = List.of(new BigDecimal("5"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("254"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        separator.countCenter1();
//        String result = separator.getCenter1();
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCountCenter1_case14() {
//        BigDecimal expected = new BigDecimal("270.0");
//        List<BigDecimal> quantities = List.of(new BigDecimal("1"), new BigDecimal("9"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("162.2"), new BigDecimal("115.2"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        separator.countCenter1();
//        String result = separator.getCenter1();
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCountCenter1_case15() {
//        BigDecimal expected = new BigDecimal("284.7");
//        List<BigDecimal> quantities = List.of(new BigDecimal("1"), new BigDecimal("1"), new BigDecimal("2"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("410.2"), new BigDecimal("375.2"), new BigDecimal("204.1"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        separator.countCenter1();
//        String result = separator.getCenter1();
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCountCenter1_case16() {
//        BigDecimal expected = new BigDecimal("298.5");
//        List<BigDecimal> quantities = List.of(new BigDecimal("1"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("1178"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        separator.countCenter1();
//        String result = separator.getCenter1();
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCountCenter1_case17() {
//        BigDecimal expected = new BigDecimal("261.0");
//        List<BigDecimal> quantities = List.of(new BigDecimal("1"), new BigDecimal("1"), new BigDecimal("1"), new BigDecimal("2"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("336"), new BigDecimal("320"), new BigDecimal("207"), new BigDecimal("187"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        separator.countCenter1();
//        String result = separator.getCenter1();
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCountCenter1_case18() {
//        BigDecimal expected = new BigDecimal("287.5");
//        List<BigDecimal> quantities = List.of(new BigDecimal("1"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("1200"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        separator.countCenter1();
//        String result = separator.getCenter1();
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCountCenter1_case19() {
//        BigDecimal expected = new BigDecimal("228.5");
//        List<BigDecimal> quantities = List.of(new BigDecimal("2"), new BigDecimal("1"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("470"), new BigDecimal("370"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        separator.countCenter1();
//        String result = separator.getCenter1();
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCountCenter1_case20() {
//        BigDecimal expected = new BigDecimal("143.5");
//        List<BigDecimal> quantities = List.of(new BigDecimal("1"), new BigDecimal("1"), new BigDecimal("1"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("1030"), new BigDecimal("305"), new BigDecimal("145"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        separator.countCenter1();
//        String result = separator.getCenter1();
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCountCenter1_case21() {
//        BigDecimal expected = new BigDecimal("244.5");
//        List<BigDecimal> quantities = List.of(new BigDecimal("10"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("125"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        separator.countCenter1();
//        String result = separator.getCenter1();
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCountCenter1_case22() {
//        BigDecimal expected = new BigDecimal("219.5");
//        List<BigDecimal> quantities = List.of(new BigDecimal("10"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("130"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        separator.countCenter1();
//        String result = separator.getCenter1();
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCountCenter1_case23() {
//        BigDecimal expected = new BigDecimal("252.0");
//        List<BigDecimal> quantities = List.of(new BigDecimal("4"), new BigDecimal("1"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("260"), new BigDecimal("215"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        separator.countCenter1();
//        String result = separator.getCenter1();
//
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCountCenter1_case24() {
//        BigDecimal expected = new BigDecimal("290.5");
//        List<BigDecimal> quantities = List.of(new BigDecimal("1"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("1194"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        separator.countCenter1();
//        String result = separator.getCenter1();
//
//        assertEquals(expected, result);
//    }
}

