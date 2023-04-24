package com.example.bladebuilder.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate date;

    @NotNull
    @JsonFormat(pattern = "HH:mm")
    private LocalTime time;

    @NotNull
    private BigDecimal thickness;

    @NotEmpty
    private String dimensionsWithQuantity;

    @NotNull
    @ManyToOne
    //TODO Zwracanie hasła
    private User user;

}
