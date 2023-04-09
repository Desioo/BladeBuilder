package com.example.bladebuilder.model.calculate;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Dimension {

    private BigDecimal size;
    private BigDecimal quantity;

    public Dimension(String quantity, String size){
        this.quantity = new BigDecimal(quantity);
        this.size = new BigDecimal(size);
    }

}
