package com.proyecto.afp.service.impl;

import com.proyecto.afp.model.Afp;
import com.proyecto.afp.repository.AfpRepository;
import com.proyecto.afp.service.AfpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AfpServiceImpl implements AfpService {

    @Autowired
    AfpRepository afpRepository;

    @Override
    public List<Afp> findAll() {
        log.info("Capa servicio: Se obtuvo toda la lista de registros afp");
        return afpRepository.findAll();
    }

    @Override
    public Afp create(Afp afp) {
        log.info("Capa servicio: Se crea un nuevo registro de afp");
        return afpRepository.save(afp);
    }

    @Override
    public Afp update(Afp afp) {
        log.info("Capa servicio: Se modifica un nuevo registro de afp");
        return afpRepository.save(afp);
    }

    @Override
    public void delete(long id) {
        log.info("Capa servicio: Se elimina un registro de afp");
        afpRepository.deleteById(id);
    }

    @Override
    public Afp findById(long id) {
        Optional<Afp> op = afpRepository.findById(id);
        log.info("Capa servicio: Se busco el registro de afp con id:",id);
        return op.isPresent() ? op.get() : new Afp();
    }
}
