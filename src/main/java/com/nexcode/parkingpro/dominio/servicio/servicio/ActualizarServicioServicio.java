package com.nexcode.parkingpro.dominio.servicio.servicio;

import com.nexcode.parkingpro.dominio.excepcion.ExcepcionRecursoNoEncontrado;
import com.nexcode.parkingpro.dominio.excepcion.ExcepcionOperacionNoPermitida;
import com.nexcode.parkingpro.dominio.excepcion.ExcepcionDeNegocio;
import com.nexcode.parkingpro.dominio.puertos.servicio.ServicioPersistencia;
import com.nexcode.parkingpro.dominio.modelo.Servicio;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ActualizarServicioServicio {

    private static final String NO_EXISTE =
            "No existe el registro que desea actualizar";

    private static final String ERROR_ACTUALIZAR =
            "Ocurrió un error al actualizar el registro";

    private final ServicioPersistencia persistencia;

    public void ejecutar(Servicio servicio) {

        if (servicio == null) {
            throw new ExcepcionOperacionNoPermitida("La entidad no puede ser nula");
        }

        Optional.ofNullable(
            persistencia.buscarPorId(servicio.getId())
        ).orElseThrow(() -> new ExcepcionRecursoNoEncontrado(NO_EXISTE));

        try {
            persistencia.actualizar(servicio);
        } catch (DataIntegrityViolationException e) {
            throw new ExcepcionDeNegocio(ERROR_ACTUALIZAR);
        }
    }
}
