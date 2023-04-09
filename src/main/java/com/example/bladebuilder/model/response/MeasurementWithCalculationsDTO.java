package com.example.bladebuilder.model.response;

import com.example.bladebuilder.model.calculate.Knife;
import com.example.bladebuilder.model.calculate.Separator;
import com.example.bladebuilder.model.entity.Measurement;
import com.example.bladebuilder.model.reguest.MeasurementRequestDTO;

public class MeasurementWithCalculationsDTO extends Measurement {

    private Separator separator;
    private Knife knife;

    public MeasurementWithCalculationsDTO(MeasurementRequestDTO measurementRequestDTO){
        this.separator = new Separator(measurementRequestDTO);
        this.knife = new Knife(measurementRequestDTO);
    }

}
