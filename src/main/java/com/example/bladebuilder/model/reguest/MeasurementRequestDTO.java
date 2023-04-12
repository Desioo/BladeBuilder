package com.example.bladebuilder.model.reguest;

import com.example.bladebuilder.model.calculate.Dimension;
import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

@Data
public class MeasurementRequestDTO {

    private List<Dimension> dimensionsList;
    private BigDecimal knivesSize;
    private BigDecimal thickness;
    private String userPassword;
    private BigDecimal actualWidth;

    private BigDecimal fullQuantity;
    private BigDecimal fullSize;
    private BigDecimal scrap = BigDecimal.ZERO;
    private BigDecimal scrapCorrection = BigDecimal.ZERO;
    private static final BigDecimal SMALL_SCRAP = new BigDecimal("6");
    private static final BigDecimal SCRAP_DIVIDER = new BigDecimal("2");


    private void countFullQuantity(){

        fullQuantity = dimensionsList.stream()
                .map(Dimension::getQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    private void countFullSize(){

        fullSize = dimensionsList.stream()
                .map((d) -> d.getQuantity().multiply(d.getSize()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    private void countScrap(){

        if(Objects.nonNull(actualWidth)){
            scrap = actualWidth.subtract(fullSize).subtract(SMALL_SCRAP);
            scrapCorrection = scrap.subtract(SMALL_SCRAP).divide(SCRAP_DIVIDER, 0, RoundingMode.DOWN);
        }

    }

    public void countSizeQuantityAndScrap(){
        countFullSize();
        countFullQuantity();
        countScrap();
    }

}
