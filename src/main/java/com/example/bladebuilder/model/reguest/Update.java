package com.example.bladebuilder.model.reguest;

import com.example.bladebuilder.exception.IncorrectDataValidateException;
import org.springframework.validation.annotation.Validated;

public interface Update {

    @Validated(Update.class)
    void validate() throws IncorrectDataValidateException;

}
