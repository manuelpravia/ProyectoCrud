package com.proyecto.afp.service;

import com.proyecto.afp.model.Bond;

import java.util.List;

public interface BondService {

    List<Bond> findAll();

    Bond create(Bond bond);

    Bond update(Bond bond);

    void delete(long id);

    Bond findById(long id);
}
