package com.example.bladebuilder.model.calculate;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Dimension {

    @NotNull
    @DecimalMin("30")
    @DecimalMax("1650")
    private BigDecimal size;

    @NotNull
    @DecimalMin("1")
    @DecimalMax("30")
    private BigDecimal quantity;

    public Dimension(String quantity, String size){
        this.quantity = new BigDecimal(quantity);
        this.size = new BigDecimal(size);
    }
}
