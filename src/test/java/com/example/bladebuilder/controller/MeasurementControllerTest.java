package com.example.bladebuilder.controller;

import com.example.bladebuilder.measurement.Measurement;
import com.example.bladebuilder.measurement.MeasurementController;
import com.example.bladebuilder.measurement.MeasurementService;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MeasurementControllerTest {

    MeasurementService measurementService = Mockito.mock(MeasurementService.class);
    MeasurementController measurementController = new MeasurementController(measurementService);

    @Test
    public void testAll() {

        // given
        List<Measurement> expectedMeasurements = new ArrayList<>();
        expectedMeasurements.add(new Measurement());

        when(measurementService.findAll()).thenReturn(expectedMeasurements);

        // when
        List<Measurement> resultMeasurements = measurementController.all();

        // then
        assertEquals(expectedMeasurements, resultMeasurements);
    }
}
