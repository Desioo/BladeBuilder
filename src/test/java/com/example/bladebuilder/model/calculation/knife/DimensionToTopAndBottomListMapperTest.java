package com.example.bladebuilder.model.calculation.knife;

import com.example.bladebuilder.model.calculation.Dimension;
import com.example.bladebuilder.model.calculation.Knife;
import com.example.bladebuilder.model.reguest.MeasurementRequestDTO;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DimensionToTopAndBottomListMapperTest {

    private void checkResult(List<List<BigDecimal>> exceptedTop, List<List<BigDecimal>> exceptedBottom,
                             BigDecimal thickness, BigDecimal knifeSize, List<Dimension> dimensions){

        //given
        MeasurementRequestDTO measurementRequestDTO = new MeasurementRequestDTO();
        measurementRequestDTO.setThickness(thickness);
        measurementRequestDTO.setKnivesSize(knifeSize);
        measurementRequestDTO.setDimensionsList(dimensions);

        Knife knife = new Knife(measurementRequestDTO);
        knife.mapDimensionsToTopAndBottomByRepeating();

        //when
        List<List<BigDecimal>> resultTop = knife.getTopSizesList();
        List<List<BigDecimal>> resultBottom = knife.getBottomSizesList();

        //then
        assertEquals(exceptedTop, resultTop);
        assertEquals(exceptedBottom, resultBottom);

    }


    @Test
    public void mapDimensionsToListByRating_case1() {

        // given
        List<List<BigDecimal>> exceptedTop = new ArrayList<>();
        exceptedTop.add(List.of(new BigDecimal("359"), new BigDecimal("3.4")));
        exceptedTop.add(List.of(new BigDecimal("339"), new BigDecimal("3.3")));
        exceptedTop.add(List.of(new BigDecimal("257")));
        exceptedTop.add(List.of(new BigDecimal("175"), new BigDecimal("3.9")));

        List<List<BigDecimal>> exceptedBottom = new ArrayList<>();
        exceptedBottom.add(List.of(new BigDecimal("339"), new BigDecimal("3.3")));
        exceptedBottom.add(List.of(new BigDecimal("359"), new BigDecimal("3.4")));
        exceptedBottom.add(List.of(new BigDecimal("233"), new BigDecimal("3.9")));
        exceptedBottom.add(List.of(new BigDecimal("199")));


        BigDecimal thickness = new BigDecimal("0.5");
        BigDecimal knifeSize = new BigDecimal("10");

        List<Dimension> dimensions = new ArrayList<>();
        dimensions.add(new Dimension("2", "362.4"));
        dimensions.add(new Dimension("1", "257"));
        dimensions.add(new Dimension("1", "199"));

        checkResult(exceptedTop, exceptedBottom, thickness, knifeSize, dimensions);

    }
}

