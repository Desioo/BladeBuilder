package com.example.bladebuilder.separator;

import com.example.bladebuilder.model.calculate.Dimension;
import com.example.bladebuilder.model.calculate.Separator;
import com.example.bladebuilder.model.reguest.MeasurementRequestDTO;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SeparatorCountCenter2Test {

    private void createAllAndCheckResult(String expected, List<Dimension> dimensions) {

        // given
        MeasurementRequestDTO measurementRequestDTO = new MeasurementRequestDTO();
        measurementRequestDTO.setDimensionsList(dimensions);
        measurementRequestDTO.countSizeQuantityAndScrap();

        Separator separator = new Separator(measurementRequestDTO);

        // when
        separator.countCenter2();
        BigDecimal result = separator.getCenter2();

        // then
        assertEquals(new BigDecimal(expected), result);

    }

    @Test
    public void testCountCenter2_case1() {

        // given
        String expected = "365.0";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("4", "235"));

        createAllAndCheckResult(expected, dimensions);

    }

    @Test
    public void testCountCenter2_case2() {

        // given
        String expected = "170.0";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("3", "220"));
        dimensions.add(new Dimension("3", "200"));

        createAllAndCheckResult(expected, dimensions);

    }

    @Test
    public void testCountCenter2_case3() {

        // given
        String expected = "770.0";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "235"));

        createAllAndCheckResult(expected, dimensions);

    }

    @Test
    public void testCountCenter2_case4() {

        // given
        String expected = "135.5";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "1504"));

        createAllAndCheckResult(expected, dimensions);

    }

    @Test
    public void testCountCenter2_case5() {

        // given
        String expected = "200.0";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("6", "200"));

        createAllAndCheckResult(expected, dimensions);

    }

    @Test
    public void testCountCenter2_case6() {

        // given
        String expected = "185.7";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("2", "684.3"));

        createAllAndCheckResult(expected, dimensions);
    }

    @Test
    public void testCountCenter2_case7() {

        //given
        String expected = "162.4";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("4", "133.9"));
        dimensions.add(new Dimension("1", "98.9"));
        dimensions.add(new Dimension("4", "133.9"));

        createAllAndCheckResult(expected, dimensions);

    }

    @Test
    public void testCountCenter2_case8() {

        // given
        String expected = "154.4";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("4", "340.3"));

        createAllAndCheckResult(expected, dimensions);

    }

    @Test
    public void testCountCenter2_case9() {

        //given
        String expected = "372.5";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("3", "320"));

        createAllAndCheckResult(expected, dimensions);

    }

    @Test
    public void testCountCenter2_case10() {

        // given
        String expected = "240.6";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("3", "335.2"));
        dimensions.add(new Dimension("1", "183.1"));

        createAllAndCheckResult(expected, dimensions);

    }

    @Test
    public void testCountCenter2_case11() {

        // given
        String expected = "95.0";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("4", "370"));

        createAllAndCheckResult(expected, dimensions);

    }

    @Test
    public void testCountCenter1_case12() {

        // given
        String expected = "279.0";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "1217"));

        createAllAndCheckResult(expected, dimensions);

    }

    @Test
    public void testCountCenter1_case13() {

        // given
        String expected = "182.5";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("5", "254"));

        createAllAndCheckResult(expected, dimensions);
    }

    @Test
    public void testCountCenter2_case14() {

        // given
        String expected = "130.5";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "162.2"));
        dimensions.add(new Dimension("9", "115.2"));

        createAllAndCheckResult(expected, dimensions);
    }

    @Test
    public void testCountCenter2_case15() {

        // given
        String expected = "238.2";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "410.2"));
        dimensions.add(new Dimension("1", "375.2"));
        dimensions.add(new Dimension("2", "204.1"));

        createAllAndCheckResult(expected, dimensions);
    }

    @Test
    public void testCountCenter2_case16() {

        // given
        String expected = "298.5";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "1178"));

        createAllAndCheckResult(expected, dimensions);
    }

    @Test
    public void testCountCenter2_case17() {

        // given
        String expected = "199.0";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "336"));
        dimensions.add(new Dimension("1", "320"));
        dimensions.add(new Dimension("1", "207"));
        dimensions.add(new Dimension("2", "187"));

        createAllAndCheckResult(expected, dimensions);
    }

    @Test
    public void testCountCenter2_case18() {

        // given
        String expected = "287.5";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "1200"));

        createAllAndCheckResult(expected, dimensions);
    }

    @Test
    public void testCountCenter2_case19() {

        // given
        String expected = "197.5";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("2", "470"));
        dimensions.add(new Dimension("1", "370"));

        createAllAndCheckResult(expected, dimensions);
    }

    @Test
    public void testCountCenter2_case20() {

        // given
        String expected = "112.5";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "1030"));
        dimensions.add(new Dimension("1", "305"));
        dimensions.add(new Dimension("1", "145"));

        createAllAndCheckResult(expected, dimensions);
    }

    @Test
    public void testCountCenter2_case21() {

        // given
        String expected = "105.0";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("10", "125"));

        createAllAndCheckResult(expected, dimensions);
    }

    @Test
    public void testCountCenter2_case22() {

        // given
        String expected = "80.0";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("10", "130"));

        createAllAndCheckResult(expected, dimensions);
    }

    @Test
    public void testCountCenter2_case23() {

        // given
        String expected = "190.0";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("4", "260"));
        dimensions.add(new Dimension("1", "215"));

        createAllAndCheckResult(expected, dimensions);
    }

    @Test
    public void testCountCenter1_case24() {

        // given
        String expected = "290.5";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "1194"));

        createAllAndCheckResult(expected, dimensions);

    }

    @Test
    public void testCountCenter1_case25() {

        // given
        String expected = "149.5";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("2", "225"));
        dimensions.add(new Dimension("5", "108"));
        dimensions.add(new Dimension("2", "103"));

        createAllAndCheckResult(expected, dimensions);

    }

    @Test
    public void testCountCenter1_case26() {

        // given
        String expected = "274.7";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "630.3"));
        dimensions.add(new Dimension("1", "560.3"));

        createAllAndCheckResult(expected, dimensions);

    }

    @Test
    public void testCountCenter1_case27() {

        // given
        String expected = "254.5";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("2", "410.3"));
        dimensions.add(new Dimension("1", "375.3"));

        createAllAndCheckResult(expected, dimensions);

    }

    @Test
    public void testCountCenter1_case28() {

        // given
        String expected = "235.9";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "410.3"));
        dimensions.add(new Dimension("1", "375.3"));
        dimensions.add(new Dimension("2", "206.3"));

        createAllAndCheckResult(expected, dimensions);

    }

    @Test
    public void testCountCenter1_case29() {

        // given
        String expected = "178.6";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "500.3"));
        dimensions.add(new Dimension("2", "252.3"));
        dimensions.add(new Dimension("3", "79.3"));

        createAllAndCheckResult(expected, dimensions);

    }

    @Test
    public void testCountCenter1_case30() {

        // given
        String expected = "194.3";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "500.3"));
        dimensions.add(new Dimension("2", "250.3"));
        dimensions.add(new Dimension("1", "176.3"));
        dimensions.add(new Dimension("1", "69.3"));

        createAllAndCheckResult(expected, dimensions);

    }

    @Test
    public void testCountCenter1_case31() {

        // given
        String expected = "420.0";

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("1", "935"));

        createAllAndCheckResult(expected, dimensions);

    }
}
