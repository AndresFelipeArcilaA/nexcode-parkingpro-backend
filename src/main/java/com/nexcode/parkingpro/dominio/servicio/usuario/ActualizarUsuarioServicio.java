package com.nexcode.parkingpro.dominio.servicio.usuario;

import com.nexcode.parkingpro.dominio.excepcion.ExcepcionRecursoNoEncontrado;
import com.nexcode.parkingpro.dominio.excepcion.ExcepcionOperacionNoPermitida;
import com.nexcode.parkingpro.dominio.excepcion.ExcepcionDeNegocio;
import com.nexcode.parkingpro.dominio.puertos.usuario.UsuarioPersistencia;
import com.nexcode.parkingpro.dominio.modelo.Usuario;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ActualizarUsuarioServicio {

    private static final String NO_EXISTE =
            "No existe el registro que desea actualizar";

    private static final String ERROR_ACTUALIZAR =
            "Ocurrió un error al actualizar el registro";

    private final UsuarioPersistencia persistencia;

    public void ejecutar(Usuario usuario) {

        if (usuario == null) {
            throw new ExcepcionOperacionNoPermitida("La entidad no puede ser nula");
        }

        Optional.ofNullable(
            persistencia.buscarPorId(usuario.getId())
        ).orElseThrow(() -> new ExcepcionRecursoNoEncontrado(NO_EXISTE));

        try {
            persistencia.actualizar(usuario);
        } catch (DataIntegrityViolationException e) {
            throw new ExcepcionDeNegocio(ERROR_ACTUALIZAR);
        }
    }
}
