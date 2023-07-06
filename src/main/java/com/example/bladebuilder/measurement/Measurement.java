package com.example.bladebuilder.measurement;

import com.example.bladebuilder.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate date;

    @JsonFormat(pattern = "HH:mm")
    private LocalTime time;

    private BigDecimal thickness;

    private String dimensionsWithQuantity;

    @ManyToOne
    //TODO Zwracanie hasła
    private User user;

}
