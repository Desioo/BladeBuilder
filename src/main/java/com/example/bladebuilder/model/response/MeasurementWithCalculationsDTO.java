package com.example.bladebuilder.model.response;

import com.example.bladebuilder.model.calculate.Dimensions;
import com.example.bladebuilder.model.calculate.Knife;
import com.example.bladebuilder.model.entity.Measurement;
import com.example.bladebuilder.model.calculate.Separator;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class MeasurementWithCalculationsDTO extends Measurement {

    Separator separator;
    Knife knife;
    private BigDecimal fullSize = BigDecimal.ZERO;
    private List<Dimensions> dimensionsList;
    private BigDecimal fullQuantities;

    private BigDecimal knivesSize;


    private void countFullQuantity(){
        fullQuantities = dimensionsList.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private void countFullSize(){
        for (int i = 0; i < sizes.size(); i++) {
            fullSize = fullSize.add(sizes.get(i).multiply(quantities.get(i)));
        }
    }


    public void countAllFromSeparatorAndKnife(){

    }
}
