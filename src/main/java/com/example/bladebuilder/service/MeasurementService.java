package com.example.bladebuilder.service;

import com.example.bladebuilder.model.entity.Measurement;

import java.util.List;
import java.util.Optional;

public class MeasurementService implements ServiceInterface<Measurement> {

    @Override
    public void save(Measurement o) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Optional<Measurement> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Measurement> findAll() {
        return null;
    }
}
