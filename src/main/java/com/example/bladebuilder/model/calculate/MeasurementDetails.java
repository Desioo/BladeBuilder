package com.example.bladebuilder.model.calculate;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class MeasurementDetails {

    private BigDecimal fullSize = BigDecimal.ZERO;
    private List<Dimension> dimensionsList;
    private BigDecimal fullQuantity;

    private BigDecimal knivesSize;

    private BigDecimal thickness;

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
