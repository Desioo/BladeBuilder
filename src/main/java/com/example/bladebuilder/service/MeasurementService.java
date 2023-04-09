package com.example.bladebuilder.service;

import com.example.bladebuilder.converter.MeasurementConverter;
import com.example.bladebuilder.model.calculate.Knife;
import com.example.bladebuilder.model.calculate.Separator;
import com.example.bladebuilder.model.entity.Measurement;
import com.example.bladebuilder.model.reguest.MeasurementRequestDTO;
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
    private final UserRepository userRepository;
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
        return measurementRepository.findById(id);
    }

    @Override
    public List<Measurement> findAll() {
      return measurementRepository.findAll();
    }

    public MeasurementWithCalculationsDTO count(MeasurementRequestDTO measurementRequestDTO){

        Measurement measurement = measurementConverter.convert(measurementRequestDTO);

        measurementRequestDTO.countFullSizeAndFullQuantity();

        Separator separator = new Separator(measurementRequestDTO);
        Knife knife = new Knife(measurementRequestDTO);

        separator.countCenter1();
        separator.countCenter2();

        knife.countCenter1();
        knife.countCenter2();

        return new MeasurementWithCalculationsDTO(separator, knife, measurement);
    }



}
