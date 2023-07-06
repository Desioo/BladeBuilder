package com.example.bladebuilder.measurement;

import com.example.bladebuilder.measurement.converter.MeasurementConverter;
import com.example.bladebuilder.measurement.reguest.MeasurementRequestDTO;
import com.example.bladebuilder.measurement.converter.MeasurementWithCalculationsConverter;
import com.example.bladebuilder.measurement.response.MeasurementWithCalculationsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final MeasurementWithCalculationsConverter measurementWithCalculationsConverter;
    private final MeasurementConverter measurementConverter;

    public void save(Measurement measurement) {
        measurementRepository.save(measurement);
    }

    public void remove(Measurement measurement) {
        measurementRepository.delete(measurement);
    }

    public Optional<Measurement> findById(Long id) {
        return measurementRepository.findById(id);
    }

    public List<Measurement> findAll() {
        return measurementRepository.findAllMeasurementOrderByIdDesc();
    }

    public List<Measurement> findAllByDate(LocalDate date) {
        return measurementRepository.findAllByDateOrderByIdDesc(date);
    }

    public MeasurementWithCalculationsDTO countAndSave(MeasurementRequestDTO measurementRequestDTO) {

        MeasurementWithCalculationsDTO measurementWithCalculationsDTO
                = measurementWithCalculationsConverter.convert(measurementRequestDTO);

        measurementWithCalculationsDTO.countAll();
        save(measurementConverter.convert(measurementWithCalculationsDTO.getMeasurement()));

        return measurementWithCalculationsDTO;
    }
}
