package com.proyecto.afp.service.impl;

import com.proyecto.afp.model.Solicitud;
import com.proyecto.afp.repository.SolicitudRepository;
import com.proyecto.afp.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;


import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SolicitudServiceImpl implements SolicitudService {

    @Autowired
    SolicitudRepository solicitudRepository;

    @Override
    public List<Solicitud> findAll() {
        return solicitudRepository.findAll();
    }

    @Override
    public Solicitud create(Solicitud solicitud) {
        if(solicitud.getMonto()>10000) { // diez mil es el monto maximo permitido por la afp
            log.warn("No se puede registrar la solicitud. Monto mayor que el permitido");
            return new Solicitud();
        }
        return solicitudRepository.save(solicitud);
    }

    @Override
    public Solicitud update(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    @Override
    public void delete(long id) {
        solicitudRepository.deleteById(id);
    }

    @Override
    public Solicitud findById(long id) {
        Optional<Solicitud> op = solicitudRepository.findById(id);
        return op.isPresent() ? op.get() : new Solicitud();
    }
}
