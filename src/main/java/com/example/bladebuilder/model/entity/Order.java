package com.example.bladebuilder.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "orders")
@RequiredArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int idSeq;
    private int seq;
    private String customer;
    @Column(length = 1000)
    private String description;
    private String invoiceNumber;
    private String thickness;
    private String width;
    private String location;
}
