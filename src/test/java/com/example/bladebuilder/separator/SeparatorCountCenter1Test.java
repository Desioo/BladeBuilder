package com.example.bladebuilder.separator;

import com.example.bladebuilder.model.calculate.Dimension;
import com.example.bladebuilder.model.calculate.MeasurementDetails;
import com.example.bladebuilder.model.calculate.Separator;
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


    @Test
    public void testCountCenter1_case2() {

        // given

        String expected = "247.5";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("3", "220"));
        dimensions.add(new Dimension("3", "200"));

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

    @Test
    public void testCountCenter1_case3() {

        // given

        String expected = "770.0";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "235"));

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

    @Test
    public void testCountCenter1_case4() {

        // given
        String expected = "135.5";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "1504"));

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

    @Test
    public void testCountCenter1_case6() {

        // given
        String expected = "289.8";
        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "275.1"));
        dimensions.add(new Dimension("4", "226.1"));

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
//
    @Test
    public void testCountCenter1_case7() {

        //given

        String expected = "286.4";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("4", "133.9"));
        dimensions.add(new Dimension("1", "98.9"));
        dimensions.add(new Dimension("4", "133.9"));

        MeasurementDetails measurementDetails = new MeasurementDetails();
        measurementDetails.setDimensionsList(dimensions);
        measurementDetails.countFullSizeAndFullQuantity();
        Separator separator = new Separator(measurementDetails);

        // when

        separator.countCenter1();
        String result = separator.getCenter1();

        // then

        assertEquals(expected, result);
    }

    @Test
    public void testCountCenter1_cas8() {

        // given

        String expected = "286.4";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("4", "133.9"));
        dimensions.add(new Dimension("1", "98.9"));
        dimensions.add(new Dimension("4", "133.9"));

        MeasurementDetails measurementDetails = new MeasurementDetails();
        measurementDetails.setDimensionsList(dimensions);
        measurementDetails.countFullSizeAndFullQuantity();

        Separator separator = new Separator(measurementDetails);

        // when

        separator.countCenter1();
        String result = separator.getCenter1();

        // then

        assertEquals(expected, result);
    }

    @Test
    public void testCountCenter1_case9() {

        //given

        String expected = "403.5";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("3", "320"));

        MeasurementDetails measurementDetails = new MeasurementDetails();
        measurementDetails.setDimensionsList(dimensions);
        measurementDetails.countFullSizeAndFullQuantity();
        Separator separator = new Separator(measurementDetails);

        // when

        separator.countCenter1();
        String result = separator.getCenter1();

        // then

        assertEquals(expected, result);
    }

    @Test
    public void testCountCenter1_case10() {
        // given
        String expected = "287.1";
        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("3", "335.2"));
        dimensions.add(new Dimension("1", "183.1"));

        MeasurementDetails measurementDetails = new MeasurementDetails();
        measurementDetails.setDimensionsList(dimensions);
        measurementDetails.countFullSizeAndFullQuantity();
        Separator separator = new Separator(measurementDetails);

        // when
        separator.countCenter1();
        String result = separator.getCenter1();

        // then
        assertEquals(expected, result);
    }

    @Test
    public void testCountCenter1_case11() {
        // given
        String expected = "141.5";
        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("4", "370"));

        MeasurementDetails measurementDetails = new MeasurementDetails();
        measurementDetails.setDimensionsList(dimensions);
        measurementDetails.countFullSizeAndFullQuantity();
        Separator separator = new Separator(measurementDetails);

        // when
        separator.countCenter1();
        String result = separator.getCenter1();

        // then
        assertEquals(expected, result);
    }

    @Test
    public void testCountCenter1_case12() {
        // given
        String expected = "279.0";
        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "1217"));

        MeasurementDetails measurementDetails = new MeasurementDetails();
        measurementDetails.setDimensionsList(dimensions);
        measurementDetails.countFullSizeAndFullQuantity();
        Separator separator = new Separator(measurementDetails);

        // when
        separator.countCenter1();
        String result = separator.getCenter1();

        // then
        assertEquals(expected, result);
    }

@Test
public void testCountCenter1_case13() {
    // given
    String expected = "244.5";
    List<Dimension> dimensions = new ArrayList<>();
    dimensions.add(new Dimension("5", "254"));

    MeasurementDetails measurementDetails = new MeasurementDetails();
    measurementDetails.setDimensionsList(dimensions);
    measurementDetails.countFullSizeAndFullQuantity();
    Separator separator = new Separator(measurementDetails);

    // when
    separator.countCenter1();
    String result = separator.getCenter1();

    // then
    assertEquals(expected, result);
}
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

