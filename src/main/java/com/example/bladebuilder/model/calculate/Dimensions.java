package com.example.bladebuilder.model.calculate;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Dimensions {

    private BigDecimal size;
    private BigDecimal quantity;

    public Dimensions(String quantity, String size){
        this.quantity = new BigDecimal(quantity);
        this.size = new BigDecimal(size);
    }

}
