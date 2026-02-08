package com.nexcode.parkingpro.dominio.servicio.usuario;

import com.nexcode.parkingpro.dominio.modelo.Usuario;
import com.nexcode.parkingpro.dominio.puertos.usuario.UsuarioPersistencia;
import com.nexcode.parkingpro.dominio.excepcion.ExcepcionRecursoNoEncontrado;

import java.util.Optional;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GuardarUsuarioServicio {

    private final UsuarioPersistencia persistencia;


    public Usuario ejecutar(Usuario usuario) {
        validarExistenciaRelaciones(usuario);
        return persistencia.guardar(usuario);
    }
    private void validarExistenciaRelaciones(Usuario usuario) {
    }
}