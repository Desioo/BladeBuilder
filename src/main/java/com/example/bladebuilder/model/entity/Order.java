package com.example.bladebuilder.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idSeq;
    private int seq;
    private String customer;
    private String description;
    private String invoiceNumber;
    private BigDecimal thickness;
    private BigDecimal width;
    private String location;

}
