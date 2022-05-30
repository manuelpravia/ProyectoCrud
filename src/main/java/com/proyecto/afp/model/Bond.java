package com.proyecto.afp.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "bond")
public class Bond {

    // Es la tabla que nos permitira vincular a la entidad AFP con el cliente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 16,max = 16, message = "numero de cuenta invalido")
    @Column(name="nroCuenta", nullable = false, length = 16)
    private String nroCuenta;

    @Column(name="montoDisp", nullable = false)
    private double montoDisp;

    @Column(name="idAfp", nullable = false )
    private long idAfp;

    @Column(name="idCustomer", nullable = false)
    private long idCostumer;
}
