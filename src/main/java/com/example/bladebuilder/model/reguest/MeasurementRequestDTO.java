package com.example.bladebuilder.model.reguest;

import com.example.bladebuilder.exception.IncorrectDataValidateException;
import com.example.bladebuilder.model.calculate.Dimension;
import jakarta.validation.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Data
public class MeasurementRequestDTO implements Update{

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    @NotEmpty
    @Valid
    private List<Dimension> dimensionsList;

    @NotNull
    @DecimalMin("10")
    @DecimalMax("20")
    private BigDecimal knivesSize;

    @NotNull
    @DecimalMin("0.1")
    @DecimalMax("4.0")
    private BigDecimal thickness;

    @NotBlank
    @Length(min = 4)
    private String userPassword;

    @DecimalMax("1650")
    private BigDecimal actualWidth;

    @NotNull(groups = Update.class)
    @DecimalMin(value = "1", groups = Update.class)
    @DecimalMax(value = "30", groups = Update.class)
    private BigDecimal fullQuantity;

    @NotNull(groups = Update.class)
    @DecimalMax(value = "1000", groups = Update.class)
    private BigDecimal fullSize;

    private BigDecimal scrap = BigDecimal.ZERO;
    private BigDecimal scrapCorrection = BigDecimal.ZERO;
    private static final BigDecimal SMALL_SCRAP = new BigDecimal("6");
    private static final BigDecimal SCRAP_DIVIDER = new BigDecimal("2");


    private void countFullQuantity() {

        fullQuantity = dimensionsList.stream()
                .map(Dimension::getQuantity)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    private void countFullSize() {

        fullSize = dimensionsList.stream()
                .map((d) -> d.getQuantity().multiply(d.getSize()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    private void countScrap() {

        if (Objects.nonNull(actualWidth)) {
            scrap = actualWidth.subtract(fullSize).subtract(SMALL_SCRAP);
            scrapCorrection = scrap.subtract(SMALL_SCRAP).divide(SCRAP_DIVIDER, 0, RoundingMode.DOWN);
        }

    }

    public void countSizeQuantityAndScrap() throws IncorrectDataValidateException {
        countFullSize();
        countFullQuantity();
        countScrap();
        validate();
    }

    @Override
    @Validated(Update.class)
    public void validate() throws IncorrectDataValidateException {

        Set<ConstraintViolation<MeasurementRequestDTO>> violations = validator.validate(this, Update.class);

        if(!violations.isEmpty()){
            throw new IncorrectDataValidateException(violations);
        }
    }

}
