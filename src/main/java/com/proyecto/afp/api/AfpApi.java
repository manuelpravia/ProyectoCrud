package com.proyecto.afp.api;

import com.proyecto.afp.exception.ModeloNotFoundException;
import com.proyecto.afp.model.Afp;
import com.proyecto.afp.service.AfpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "afps")
public class AfpApi {

    @Autowired
    AfpService afpService;

    @GetMapping
    public ResponseEntity<List<Afp>> findAll(){
        log.info("Capa Controller: Obteniendo la lista de AFPs");
        return ResponseEntity.ok(afpService.findAll());
    }


    @PostMapping
    public ResponseEntity<Afp> create(@Valid @RequestBody Afp afp){
        Afp afpResponse = afpService.create(afp);
        log.info("Capa Controller: Creando nuevo registro de afp");
        return new ResponseEntity<>(afpResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Afp> update(@Valid @RequestBody Afp afp){
        log.info("Capa Controller: Modificando nuevo registro de afp");
        return ResponseEntity.ok(afpService.update(afp));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Afp> findById(@PathVariable("id") long id){
        Afp afp = afpService.findById(id);
        if(afp.getId() == 0){
            throw  new ModeloNotFoundException("ID no encontrado");
        }
        return ResponseEntity.ok(afpService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id){
        Afp afp = afpService.findById(id);
        if(afp.getId() == 0){
            throw  new ModeloNotFoundException("ID no encontrado");
        }
        afpService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
