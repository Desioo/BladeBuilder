package com.example.bladebuilder.model.response;

import com.example.bladebuilder.model.calculate.Knife;
import com.example.bladebuilder.model.calculate.Separator;
import com.example.bladebuilder.model.entity.Measurement;


public record MeasurementWithCalculationsDTO(Separator separator, Knife knife, Measurement measurement) {
}
