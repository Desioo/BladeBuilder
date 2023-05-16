package com.example.bladebuilder.controller;

import com.example.bladebuilder.model.entity.Measurement;
import com.example.bladebuilder.model.reguest.MeasurementRequestDTO;
import com.example.bladebuilder.model.response.MeasurementWithCalculationsDTO;
import com.example.bladebuilder.service.MeasurementService;
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
