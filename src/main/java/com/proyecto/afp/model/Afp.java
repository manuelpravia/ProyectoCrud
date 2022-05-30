package com.proyecto.afp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "afp")
public class Afp {

    ///Atributos de la entidad AFP que podria ser: PRIMA, INTEGRA, PROFUTURO, HABITAT
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombre",nullable = false,length = 50)
    private String nombre;

    @Column(name = "direccion",nullable = false, length = 80)
    private String direccion;
}
