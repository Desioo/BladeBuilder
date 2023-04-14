package com.example.bladebuilder.repository;

import com.example.bladebuilder.model.entity.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

    @Query("SELECT m FROM Measurement m ORDER BY ID DESC")
    List<Measurement> findAllMeasurement();

}
