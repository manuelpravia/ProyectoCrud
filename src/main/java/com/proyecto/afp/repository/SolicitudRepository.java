package com.proyecto.afp.repository;

import com.proyecto.afp.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud,Long> {
}
