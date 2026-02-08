package com.nexcode.parkingpro.dominio.servicio.parqueadero;

import com.nexcode.parkingpro.dominio.excepcion.ExcepcionRecursoNoEncontrado;
import com.nexcode.parkingpro.dominio.excepcion.ExcepcionOperacionNoPermitida;
import com.nexcode.parkingpro.dominio.excepcion.ExcepcionDeNegocio;
import com.nexcode.parkingpro.dominio.puertos.parqueadero.ParqueaderoPersistencia;
import com.nexcode.parkingpro.dominio.modelo.Parqueadero;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ActualizarParqueaderoServicio {

    private static final String NO_EXISTE =
            "No existe el registro que desea actualizar";

    private static final String ERROR_ACTUALIZAR =
            "Ocurrió un error al actualizar el registro";

    private final ParqueaderoPersistencia persistencia;

    public void ejecutar(Parqueadero parqueadero) {

        if (parqueadero == null) {
            throw new ExcepcionOperacionNoPermitida("La entidad no puede ser nula");
        }

        Optional.ofNullable(
            persistencia.buscarPorId(parqueadero.getId())
        ).orElseThrow(() -> new ExcepcionRecursoNoEncontrado(NO_EXISTE));

        try {
            persistencia.actualizar(parqueadero);
        } catch (DataIntegrityViolationException e) {
            throw new ExcepcionDeNegocio(ERROR_ACTUALIZAR);
        }
    }
}
