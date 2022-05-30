package com.proyecto.afp.service.impl;

import com.proyecto.afp.model.Afp;
import com.proyecto.afp.model.Bond;
import com.proyecto.afp.repository.BondRepository;
import com.proyecto.afp.service.BondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BondServiceImpl implements BondService {

    @Autowired
    BondRepository bondRepository;


    @Override
    public List<Bond> findAll() {
        log.info("Capa servicio: Se Obtuvo la lista de registros de bond ");
        return bondRepository.findAll();
    }

    @Override
    public Bond create(Bond bond) {
        return bondRepository.save(bond);
    }

    @Override
    public Bond update(Bond bond) {
        return bondRepository.save(bond);
    }

    @Override
    public void delete(long id) {
        bondRepository.deleteById(id);
    }

    @Override
    public Bond findById(long id) {
        Optional<Bond> op = bondRepository.findById(id);
        log.info("Capa servicio: Se busco el registro de bond con id:",id);
        return op.isPresent() ? op.get() : new Bond();
    }
}
