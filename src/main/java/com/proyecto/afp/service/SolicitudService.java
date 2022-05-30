package com.proyecto.afp.service;

import com.proyecto.afp.model.Solicitud;

import java.util.List;

public interface SolicitudService {

    List<Solicitud> findAll();

    Solicitud create(Solicitud solicitud);

    Solicitud update(Solicitud solicitud);

    void delete(long id);

    Solicitud findById(long id);
}
