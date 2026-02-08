package com.nexcode.parkingpro.dominio.servicio.usuario;

import com.nexcode.parkingpro.dominio.excepcion.ExcepcionRecursoNoEncontrado;
import com.nexcode.parkingpro.dominio.modelo.Usuario;
import com.nexcode.parkingpro.dominio.puertos.usuario.UsuarioPersistencia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IniciarSesionServicio {

    private final UsuarioPersistencia persistencia;

    public Usuario ejecutar(String correo, String contrasena) {
        return Optional.ofNullable(persistencia.buscarPorCorreoYContrasena(correo, contrasena))
                .orElseThrow(() ->
                        new ExcepcionRecursoNoEncontrado("Las credenciales son incorrectas")
                );
    }
}
