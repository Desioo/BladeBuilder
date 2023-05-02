package com.example.bladebuilder.model.reguest;

import com.example.bladebuilder.exception.IncorrectUpdateDataValidateException;
import org.springframework.validation.annotation.Validated;

public interface UpdateData {

    @Validated(UpdateData.class)
    void validate() throws IncorrectUpdateDataValidateException;

}
