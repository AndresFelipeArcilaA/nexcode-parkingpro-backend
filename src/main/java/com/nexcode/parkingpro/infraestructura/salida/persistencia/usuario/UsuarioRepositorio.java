package com.nexcode.parkingpro.infraestructura.salida.persistencia.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<UsuarioEntidad, Long> {

    @Query("SELECT u FROM UsuarioEntidad u WHERE u.correo = :correo AND u.contrasena = :contrasena")
    Optional<UsuarioEntidad> findByCorreoAndContrasena(@Param("correo") String correo, @Param("contrasena") String contrasena);

}
