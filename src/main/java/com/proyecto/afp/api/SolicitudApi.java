package com.proyecto.afp.api;

import com.proyecto.afp.exception.ModeloNotFoundException;
import com.proyecto.afp.model.Solicitud;
import com.proyecto.afp.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import javax.servlet.http.HttpServletRequest;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "solicitudes")
public class SolicitudApi {

    @Autowired
    SolicitudService solicitudService;

    @GetMapping
    public ResponseEntity<List<Solicitud>> findAll(){
        return ResponseEntity.ok(solicitudService.findAll());
    }


    @PostMapping
    public ResponseEntity<Solicitud> create(@Valid @RequestBody Solicitud solicitud){
        Solicitud solicitudResponse = solicitudService.create(solicitud);
        return new ResponseEntity<>(solicitudResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Solicitud> update(@Valid @RequestBody Solicitud solicitud){
        return ResponseEntity.ok(solicitudService.update(solicitud));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solicitud> findById(@PathVariable("id") long id){
        Solicitud solicitud = solicitudService.findById(id);
        if(solicitud.getId() == 0){
            throw  new ModeloNotFoundException("ID no encontrado");
        }
        return ResponseEntity.ok(solicitudService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id){
        Solicitud solicitud = solicitudService.findById(id);
        if(solicitud.getId() == 0){
            throw  new ModeloNotFoundException("ID no encontrado");
        }
        solicitudService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
