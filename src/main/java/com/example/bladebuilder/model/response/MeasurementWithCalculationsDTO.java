package com.example.bladebuilder.model.response;

import com.example.bladebuilder.model.calculate.Dimensions;
import com.example.bladebuilder.model.calculate.Knife;
import com.example.bladebuilder.model.entity.Measurement;
import com.example.bladebuilder.model.calculate.Separator;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class MeasurementWithCalculationsDTO extends Measurement {

    private final Separator separator;
    private Knife knife;
    private BigDecimal fullSize = BigDecimal.ZERO;
    private List<Dimensions> dimensionsList;
    private BigDecimal fullQuantity;

    private BigDecimal knivesSize;

    public MeasurementWithCalculationsDTO() {
        super();
        this.dimensionsList = new ArrayList<>();
        this.separator = new Separator();
        this.knife = new Knife();
    }

    private void countFullQuantity(){

        fullQuantity = dimensionsList.stream()
                .map(Dimensions::getQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    private void countFullSize(){

      fullSize = dimensionsList.stream()
              .map((d) -> d.getQuantity().multiply(d.getSize()))
              .reduce(BigDecimal.ZERO, BigDecimal::add);

    }


    public void countAllFromSeparatorAndKnife(){
        countFullQuantity();
        countFullSize();
        separator.countCenter1();
        separator.countCenter2();
    }
}
