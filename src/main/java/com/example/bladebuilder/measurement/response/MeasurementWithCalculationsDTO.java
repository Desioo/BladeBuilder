package com.example.bladebuilder.measurement.response;

import com.example.bladebuilder.calculation.CenterCalculator;
import com.example.bladebuilder.calculation.Knife;
import com.example.bladebuilder.calculation.Separator;
import com.example.bladebuilder.measurement.MeasurementDetails;
import lombok.Data;

@Data
public class MeasurementWithCalculationsDTO {

    private Separator separator;
    private Knife knife;
    private MeasurementResponseDTO measurement;
    private MeasurementDetails measurementDetails;

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
