package com.example.bladebuilder.model.response;

import com.example.bladebuilder.converter.MeasurementConverter;
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

    public MeasurementWithCalculationsDTO(MeasurementRequestDTO measurementRequestDTO){

        measurementRequestDTO.countFullSizeAndFullQuantity();

        this.separator = new Separator(measurementRequestDTO);
        this.knife = new Knife(measurementRequestDTO);
        this.measurement = new MeasurementConverter().convert(measurementRequestDTO);

        countAll();
    }

    private void countAll(){

        countCenters(separator);
        countCenters(knife);

    }

    private <O extends CenterCalculator> void  countCenters(O o){

        o.countCenter1();
        o.countCenter2();

    }

}
