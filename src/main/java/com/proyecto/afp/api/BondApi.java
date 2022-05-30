package com.proyecto.afp.api;

import com.proyecto.afp.exception.ModeloNotFoundException;
import com.proyecto.afp.model.Bond;
import com.proyecto.afp.service.BondService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "bonds")
public class BondApi {

    @Autowired
    BondService bondService;

    @GetMapping
    public ResponseEntity<List<Bond>> findAll(){
        return ResponseEntity.ok(bondService.findAll());
    }


    @PostMapping
    public ResponseEntity<Bond> create(@Valid @RequestBody Bond bond){
        Bond bondResponse = bondService.create(bond);
        return new ResponseEntity<>(bondResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Bond> update(@Valid @RequestBody Bond bond){
        return ResponseEntity.ok(bondService.update(bond));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bond> findById(@PathVariable("id") long id){
        Bond afp = bondService.findById(id);
        if(afp.getId() == 0){
            throw  new ModeloNotFoundException("ID no encontrado");
        }
        return ResponseEntity.ok(bondService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id){
        Bond afp = bondService.findById(id);
        if(afp.getId() == 0){
            throw  new ModeloNotFoundException("ID no encontrado");
        }
        bondService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
