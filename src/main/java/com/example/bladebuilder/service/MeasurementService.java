package com.example.bladebuilder.service;

import com.example.bladebuilder.converter.MeasurementConverter;
import com.example.bladebuilder.converter.MeasurementDetailsConverter;
import com.example.bladebuilder.model.entity.Measurement;
import com.example.bladebuilder.model.reguest.MeasurementRequestDTO;
import com.example.bladebuilder.model.response.MeasurementDetails;
import com.example.bladebuilder.model.response.MeasurementWithCalculationsDTO;
import com.example.bladebuilder.repository.MeasurementRepository;
import com.example.bladebuilder.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MeasurementService implements ServiceInterface<Measurement> {

    private final MeasurementRepository measurementRepository;
    private final MeasurementConverter measurementConverter;
    private final MeasurementDetailsConverter measurementDetailsConverter;


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
        return measurementRepository.findById(id);
    }

    @Override
    public List<Measurement> findAll() {
      return measurementRepository.findAll();
    }

    public MeasurementWithCalculationsDTO count(MeasurementRequestDTO measurementRequestDTO){

        //TODO

        measurementRequestDTO.countFullSizeAndFullQuantity();

        Measurement measurement = measurementConverter.convert(measurementRequestDTO);
        save(measurement);
        MeasurementDetails measurementDetails = measurementDetailsConverter.convert(measurementRequestDTO);

        return  new MeasurementWithCalculationsDTO(measurementRequestDTO, measurement, measurementDetails);
    }
}
