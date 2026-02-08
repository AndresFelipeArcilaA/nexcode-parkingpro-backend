package com.nexcode.parkingpro.infraestructura.salida.persistencia.lugar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LugarRepositorio extends JpaRepository<LugarEntidad, Long> {

}
