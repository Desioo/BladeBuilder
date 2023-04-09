package com.example.bladebuilder.model.response;

import com.example.bladebuilder.model.calculate.Knife;
import com.example.bladebuilder.model.calculate.Separator;
import com.example.bladebuilder.model.entity.Measurement;
import lombok.Data;

@Data
public class MeasurementWithCalculationsDTO extends Measurement {

    private final Separator separator;
    private Knife knife;

}
