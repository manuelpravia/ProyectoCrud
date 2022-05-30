package com.proyecto.afp.exception;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ExceptionResponse {

    // Parametros para retornar la excepcion que se pueda dar durante el registro
    private LocalDateTime fecha;
    private String mensaje;
    private  String detalles;
}
