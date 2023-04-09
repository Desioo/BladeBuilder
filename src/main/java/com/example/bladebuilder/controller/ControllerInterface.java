package com.example.bladebuilder.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ControllerInterface<O, R> {

    @GetMapping("/{o}")
    R get(@PathVariable O o);

    @PostMapping("")
    String add(@RequestBody O o);

    @DeleteMapping("/{o}")
    String remove(@PathVariable O o);

    @PutMapping("/{o}")
    String edit(@PathVariable O o, @RequestBody String value);

    @GetMapping("/all")
    List<R> findAll();

}