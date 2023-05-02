package com.example.bladebuilder.exception;

import com.example.bladebuilder.model.reguest.MeasurementRequestDTO;
import jakarta.validation.ConstraintViolation;
import lombok.Data;

import java.util.Set;

@Data
public class IncorrectDataValidateException extends Throwable {

    private final Set<ConstraintViolation<MeasurementRequestDTO>> violations;

}
