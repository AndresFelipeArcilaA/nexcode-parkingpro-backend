package com.nexcode.parkingpro.infraestructura.salida.persistencia.factura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FacturaRepositorio extends JpaRepository<FacturaEntidad, Long> {

}
