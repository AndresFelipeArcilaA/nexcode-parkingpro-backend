package com.nexcode.parkingpro.infraestructura.salida.persistencia.tiposervicio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TipoServicioRepositorio extends JpaRepository<TipoServicioEntidad, Long> {

}
