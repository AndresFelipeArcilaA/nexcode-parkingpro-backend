package com.nexcode.parkingpro.dominio.servicio.servicio;

import com.nexcode.parkingpro.dominio.excepcion.ExcepcionRecursoNoEncontrado;
import com.nexcode.parkingpro.dominio.excepcion.ExcepcionDeNegocio;
import com.nexcode.parkingpro.dominio.puertos.servicio.ServicioPersistencia;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EliminarServicioServicio {

    private static final String NO_EXISTE =
            "No existe el registro que desea eliminar";

    private static final String TIENE_RELACIONES =
            "No se puede eliminar el registro porque tiene dependencias asociadas";

    private final ServicioPersistencia persistencia;

    public void ejecutar(Long id) {

        Optional.ofNullable(persistencia.buscarPorId(id))
                .orElseThrow(() -> new ExcepcionRecursoNoEncontrado(NO_EXISTE));

        try {
            persistencia.eliminar(id);
        } catch (DataIntegrityViolationException ex) {
            throw new ExcepcionDeNegocio(TIENE_RELACIONES);
        }
    }
}