package com.nexcode.parkingpro.infraestructura.salida.persistencia.pagosubscripcion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PagoSubscripcionRepositorio extends JpaRepository<PagoSubscripcionEntidad, Long> {

}
