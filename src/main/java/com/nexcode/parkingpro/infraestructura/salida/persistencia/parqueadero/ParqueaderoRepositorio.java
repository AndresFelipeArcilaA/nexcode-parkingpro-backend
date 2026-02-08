package com.nexcode.parkingpro.infraestructura.salida.persistencia.parqueadero;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ParqueaderoRepositorio extends JpaRepository<ParqueaderoEntidad, Long> {

    @Query("SELECT p FROM ParqueaderoEntidad p WHERE p.usuario.id = :usuarioId")
    Optional<ParqueaderoEntidad> findByUsuarioId(@Param("usuarioId") Long usuarioId);

}
