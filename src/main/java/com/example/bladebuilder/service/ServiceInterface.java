package com.example.bladebuilder.service;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface<O> {

    void save(O o);

    void remove(O o);

    Optional<O> findById(Long id);

    List<O> findAll();

}
