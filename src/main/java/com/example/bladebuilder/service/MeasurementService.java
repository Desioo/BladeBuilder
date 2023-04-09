package com.example.bladebuilder.service;

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

    @Override
    public void save(Measurement o) {
        measurementRepository.save(o);
    }

    @Override
    public void remove(Measurement o) {
        measurementRepository.delete(o);
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

    }

}
