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

    @Test
    public void testCountCenter1_case14() {
        // given
        String expected = "270.0";
        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "162.2"));
        dimensions.add(new Dimension("9", "115.2"));

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
    public void testCountCenter1_case15() {
        // given
        String expected = "284.7";
        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "410.2"));
        dimensions.add(new Dimension("1", "375.2"));
        dimensions.add(new Dimension("2", "204.1"));

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
    public void testCountCenter1_case16() {
        // given
        String expected = "298.5";
        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "1178"));

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
    public void testCountCenter1_case17() {
        // given
        String expected = "261.0";
        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "336"));
        dimensions.add(new Dimension("1", "320"));
        dimensions.add(new Dimension("1", "207"));
        dimensions.add(new Dimension("2", "187"));

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
    public void testCountCenter1_case18() {
        // given
        String expected = "287.5";
        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "1200"));

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
    public void testCountCenter1_case19() {
        // given
        String expected = "228.5";
        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("2", "470"));
        dimensions.add(new Dimension("1", "370"));

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
    public void testCountCenter1_case20() {
        // given
        String expected = "143.5";
        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "1030"));
        dimensions.add(new Dimension("1", "305"));
        dimensions.add(new Dimension("1", "145"));

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
    public void testCountCenter1_case21() {
        // given
        String expected = "244.5";
        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("10", "125"));

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
    public void testCountCenter1_case22() {
        // given
        String expected = "219.5";
        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("10", "130"));

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
    public void testCountCenter1_case23() {
        // given
        String expected = "252.0";
        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("4", "260"));
        dimensions.add(new Dimension("1", "215"));

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
    public void testCountCenter1_case24() {
        // given
        String expected = "290.5";
        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "1194"));

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

}

