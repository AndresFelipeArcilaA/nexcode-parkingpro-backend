package com.nexcode.parkingpro.infraestructura.salida.persistencia.servicio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ServicioRepositorio extends JpaRepository<ServicioEntidad, Long> {

}
