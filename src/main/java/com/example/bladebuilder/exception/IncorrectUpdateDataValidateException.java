package com.example.bladebuilder.exception;

import com.example.bladebuilder.model.reguest.UpdateData;
import jakarta.validation.ConstraintViolation;
import lombok.Data;

import java.util.Set;

@Data
public class IncorrectUpdateDataValidateException extends Throwable {

    private final Set<ConstraintViolation<UpdateData>> violations;

}
