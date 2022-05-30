package com.proyecto.afp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "solicitud")
public class Solicitud {

    // Es la tabla donde se registra la solicitud del cliente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="monto", nullable = false)
    private double monto;

    @Column(name="idAfp", nullable = false)
    private long idAfp;

    @Column(name="idCustomer", nullable = false)
    private long idCustomer;
}
