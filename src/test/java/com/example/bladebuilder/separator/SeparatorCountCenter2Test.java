//package com.example.bladebuilder.separator;
//
//import org.junit.Test;
//import pl.coderslab.model.Separator;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//
//public class SeparatorCountCenter2Test {
//
//
//    @Test
//    public void testCalculateCenter2_1Dimension_case1() {
//
//        // given
//
//        String expected = "365.0";
//        List<BigDecimal> quantities = List.of(new BigDecimal("4"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("235"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        // when
//
//        separator.countCenter2();
//        String result = separator.getCenter2();
//
//        // then
//
//        assertEquals(expected, result);
//
//    }
//
//    @Test
//    public void testCalculateCenter2_3Dimension_case2() {
//
//        // given
//        String expected = "149.5";
//        List<BigDecimal> quantities = List.of(new BigDecimal("2"), new BigDecimal("5"), new BigDecimal("2"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("225"), new BigDecimal("108"), new BigDecimal("103"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        // when
//        separator.countCenter2();
//        String result = separator.getCenter2();
//
//        // then
//        assertEquals(expected, result);
//
//    }
//
//    @Test
//    public void testCalculateCenter2_2Dimension_case3() {
//
//        // given
//        String expected = "170.0";
//        List<BigDecimal> quantities = List.of(new BigDecimal("3"), new BigDecimal("3"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("220"), new BigDecimal("200"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        // when
//        separator.countCenter2();
//        String result = separator.getCenter2();
//
//        // then
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCalculateCenter2_1Dimension_case2() {
//
//        // given
//        String expected = "770.0";
//        List<BigDecimal> quantities = List.of(new BigDecimal("1"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("235"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        // when
//        separator.countCenter2();
//        String result = separator.getCenter2();
//
//        // then
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCalculateCenter2_1Dimension_case3() {
//
//        // given
//        String expected = "135.5";
//        List<BigDecimal> quantities = List.of(new BigDecimal("1"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("1504"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        // when
//        separator.countCenter2();
//        String result = separator.getCenter2();
//
//        // then
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCalculateCenter2_1Dimension_case4() {
//
//        // given
//        String expected = "200.0";
//        List<BigDecimal> quantities = List.of(new BigDecimal("6"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("200"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        // when
//        separator.countCenter2();
//        String result = separator.getCenter2();
//
//        // then
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCalculateCenter2_1Dimension_case5() {
//
//        // given
//        String expected = "95.0";
//        List<BigDecimal> quantities = List.of(new BigDecimal("4"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("370"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        // when
//        separator.countCenter2();
//        String result = separator.getCenter2();
//
//        // then
//        assertEquals(expected, result);
//    }
//
//    @Test
//    public void testCalculateCenter2_1Dimension_case6() {
//
//        // given
//        String expected = "372.5";
//        List<BigDecimal> quantities = List.of(new BigDecimal("3"));
//        List<BigDecimal> sizes = List.of(new BigDecimal("320"));
//
//        Separator separator = new Separator();
//        separator.setSizes(sizes);
//        separator.setQuantities(quantities);
//        separator.countFullSizeAndFullQuantity();
//
//        // when
//        separator.countCenter2();
//        String result = separator.getCenter2();
//
//        // then
//        assertEquals(expected, result);
//    }
//
//}