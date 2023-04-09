package com.example.bladebuilder.repository;

import com.example.bladebuilder.model.entity.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
}
