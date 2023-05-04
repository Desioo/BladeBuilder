package com.example.bladebuilder.service;

import com.example.bladebuilder.converter.entity.MeasurementConverter;
import com.example.bladebuilder.converter.response.MeasurementWithCalculationsConverter;
import com.example.bladebuilder.exception.IncorrectUpdateDataValidateException;
import com.example.bladebuilder.model.entity.Measurement;
import com.example.bladebuilder.model.reguest.MeasurementRequestDTO;
import com.example.bladebuilder.model.response.MeasurementWithCalculationsDTO;
import com.example.bladebuilder.repository.MeasurementRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MeasurementService implements ServiceInterface<Measurement> {

    private final MeasurementRepository measurementRepository;
    private final MeasurementWithCalculationsConverter measurementWithCalculationsConverter;
    private final MeasurementConverter measurementConverter;


    @Override
    public void save(Measurement measurement) {
        measurementRepository.save(measurement);
    }

    @Override
    public void remove(Measurement measurement) {
        measurementRepository.delete(measurement);
    }

    @Override
    public Optional<Measurement> findById(Long id) {

        Optional<Measurement> measurement = measurementRepository.findById(id);

        measurement.ifPresent(this::getUserToMeasurement);

        return measurement;
    }

    @Override
    public List<Measurement> findAll() {

        List<Measurement> measurements = measurementRepository.findAllMeasurementOrderByIdDesc();
        getUsersToMeasurementList(measurements);

        return measurements;
    }

    public List<Measurement> findAllByDate(LocalDate date){

        List<Measurement> measurements = measurementRepository.findAllByDateOrderByIdDesc(date);
        getUsersToMeasurementList(measurements);

        return measurements;
    }

    public MeasurementWithCalculationsDTO count(MeasurementRequestDTO measurementRequestDTO){

        MeasurementWithCalculationsDTO measurementWithCalculationsDTO
                = measurementWithCalculationsConverter.convert(measurementRequestDTO);

        measurementWithCalculationsDTO.countAll();
        save(measurementConverter.convert(measurementWithCalculationsDTO.getMeasurement()));

        return measurementWithCalculationsDTO;
    }

    private void getUsersToMeasurementList(List<Measurement> measurements){
        measurements.forEach(m -> Hibernate.initialize(m.getUser()));
    }

    private void getUserToMeasurement(Measurement measurement){
       Hibernate.initialize(measurement.getUser());
    }

}
