package com.nexcode.parkingpro.dominio.servicio.lugar;

import com.nexcode.parkingpro.dominio.excepcion.ExcepcionRecursoNoEncontrado;
import com.nexcode.parkingpro.dominio.excepcion.ExcepcionOperacionNoPermitida;
import com.nexcode.parkingpro.dominio.excepcion.ExcepcionDeNegocio;
import com.nexcode.parkingpro.dominio.puertos.lugar.LugarPersistencia;
import com.nexcode.parkingpro.dominio.modelo.Lugar;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ActualizarLugarServicio {

    private static final String NO_EXISTE =
            "No existe el registro que desea actualizar";

    private static final String ERROR_ACTUALIZAR =
            "Ocurrió un error al actualizar el registro";

    private final LugarPersistencia persistencia;

    public void ejecutar(Lugar lugar) {

        if (lugar == null) {
            throw new ExcepcionOperacionNoPermitida("La entidad no puede ser nula");
        }

        Optional.ofNullable(
            persistencia.buscarPorId(lugar.getId())
        ).orElseThrow(() -> new ExcepcionRecursoNoEncontrado(NO_EXISTE));

        try {
            persistencia.actualizar(lugar);
        } catch (DataIntegrityViolationException e) {
            throw new ExcepcionDeNegocio(ERROR_ACTUALIZAR);
        }
    }
}
