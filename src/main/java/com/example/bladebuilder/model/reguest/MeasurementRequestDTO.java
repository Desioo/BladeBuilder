package com.example.bladebuilder.model.reguest;

import com.example.bladebuilder.model.calculate.Dimension;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

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
    private BigDecimal scrapCorrection;


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

    public void countFullSizeAndFullQuantity(){
        countFullSize();
        countFullQuantity();
    }

}
