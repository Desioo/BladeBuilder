package com.example.bladebuilder.measurement;

import com.example.bladebuilder.measurement.Measurement;
import com.example.bladebuilder.measurement.reguest.MeasurementRequestDTO;
import com.example.bladebuilder.measurement.response.MeasurementWithCalculationsDTO;
import com.example.bladebuilder.measurement.MeasurementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/measurement")
@RequiredArgsConstructor
@Validated
public class MeasurementController {

    private final MeasurementService measurementService;

    @Transactional
    @PostMapping("")
    public MeasurementWithCalculationsDTO count(@RequestBody @Valid MeasurementRequestDTO measurementRequestDTO) {
        return measurementService.countAndSave(measurementRequestDTO);
    }

    @GetMapping("/all")
    public List<Measurement> all() {
        return measurementService.findAll();
    }

    @GetMapping("/all/date/{date}")
    public List<Measurement> all(@PathVariable LocalDate date) {
        return measurementService.findAllByDate(date);
    }
}
