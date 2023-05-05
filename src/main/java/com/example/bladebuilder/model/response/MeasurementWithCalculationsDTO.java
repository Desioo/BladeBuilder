package com.example.bladebuilder.model.response;

import com.example.bladebuilder.model.calculation.CenterCalculator;
import com.example.bladebuilder.model.calculation.Knife;
import com.example.bladebuilder.model.calculation.Separator;
import lombok.Data;

@Data
public class MeasurementWithCalculationsDTO {

    private  Separator separator;
    private  Knife knife;
    private  MeasurementResponseDTO measurement;
    private  MeasurementDetails measurementDetails;

    public void countAll() {

        countCenters(separator);
        countCenters(knife);
        knife.mapDimensionsToTopAndBottomByRepeating();

    }

    private <O extends CenterCalculator> void countCenters(O o) {

        o.countCenter2();
        o.countCenter1();

    }

}
