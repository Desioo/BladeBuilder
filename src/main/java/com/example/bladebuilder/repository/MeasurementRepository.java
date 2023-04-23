package com.example.bladebuilder.repository;

import com.example.bladebuilder.model.entity.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

    @Query("SELECT m FROM Measurement m ORDER BY m.id DESC")
    List<Measurement> findAllMeasurementOrderByIdDesc();

    @Query("SELECT m FROM Measurement  m WHERE m.date =:date ORDER BY m.id DESC")
    List<Measurement> findAllByDateOrderByIdDesc(@Param("date") LocalDate date);

}
