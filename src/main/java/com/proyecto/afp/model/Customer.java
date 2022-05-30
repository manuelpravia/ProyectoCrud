package com.proyecto.afp.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    // Es el cliente quien tiene la opcion de ser afiliado y solicitar un monto de retiro
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nombres",nullable = false,length = 80)
    private String nombres;

    @Column(name = "apellidos",nullable = false,length = 80)
    private String apellidos;

    @Pattern(regexp = "^[0-9]*$" , message = "DNI debe contener solo numeros")
    @Size(min = 8,max = 8, message = "DNI debe tener 8 caracteres")
    @Column(name = "dni",nullable = false,length = 8)
    private String dni;

    @Pattern(regexp = "^[0-9]*$" , message = "Telefono debe contener solo numeros")
    @Size(min = 9,max = 9, message = "Telefono debe tener 9 caracteres")
    @Column(name = "telefono",nullable = false,length = 9)
    private String telefono;

    @Column(name = "correo",nullable = false,length = 80)
    private String correo;
}
