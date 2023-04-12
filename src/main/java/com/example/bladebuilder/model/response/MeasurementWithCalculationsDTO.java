package com.example.bladebuilder.model.response;

import com.example.bladebuilder.model.calculate.CenterCalculator;
import com.example.bladebuilder.model.calculate.Knife;
import com.example.bladebuilder.model.calculate.Separator;
import com.example.bladebuilder.model.entity.Measurement;
import com.example.bladebuilder.model.reguest.MeasurementRequestDTO;
import lombok.Getter;

@Getter
public class MeasurementWithCalculationsDTO {

    private final Separator separator;
    private final Knife knife;
    private final Measurement measurement;
    private final MeasurementDetails measurementDetails;

    public MeasurementWithCalculationsDTO(MeasurementRequestDTO measurementRequestDTO, Measurement measurement, MeasurementDetails measurementDetails) {

        this.separator = new Separator(measurementRequestDTO);
        this.knife = new Knife(measurementRequestDTO);
        this.measurement = measurement;
        this.measurementDetails = measurementDetails;

        countAll();
    }

    private void countAll() {

        countCenters(separator);
        countCenters(knife);
        knife.mapDimensionsToTopAndBottomByRepeating();

    }

    private <O extends CenterCalculator> void countCenters(O o) {

        o.countCenter2();
        o.countCenter1();

    }

}
