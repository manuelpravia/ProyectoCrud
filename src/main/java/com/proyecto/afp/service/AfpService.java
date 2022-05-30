package com.proyecto.afp.service;

import com.proyecto.afp.model.Afp;

import java.util.List;

public interface AfpService {

    List<Afp> findAll();

    Afp create(Afp afp);

    Afp update(Afp afp);

    void delete(long id);

    Afp findById(long id);
}
