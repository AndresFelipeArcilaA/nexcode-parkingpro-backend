package com.nexcode.parkingpro.dominio.servicio.factura;

import com.nexcode.parkingpro.dominio.excepcion.ExcepcionRecursoNoEncontrado;
import com.nexcode.parkingpro.dominio.excepcion.ExcepcionOperacionNoPermitida;
import com.nexcode.parkingpro.dominio.excepcion.ExcepcionDeNegocio;
import com.nexcode.parkingpro.dominio.puertos.factura.FacturaPersistencia;
import com.nexcode.parkingpro.dominio.modelo.Factura;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ActualizarFacturaServicio {

    private static final String NO_EXISTE =
            "No existe el registro que desea actualizar";

    private static final String ERROR_ACTUALIZAR =
            "Ocurrió un error al actualizar el registro";

    private final FacturaPersistencia persistencia;

    public void ejecutar(Factura factura) {

        if (factura == null) {
            throw new ExcepcionOperacionNoPermitida("La entidad no puede ser nula");
        }

        Optional.ofNullable(
            persistencia.buscarPorId(factura.getId())
        ).orElseThrow(() -> new ExcepcionRecursoNoEncontrado(NO_EXISTE));

        try {
            persistencia.actualizar(factura);
        } catch (DataIntegrityViolationException e) {
            throw new ExcepcionDeNegocio(ERROR_ACTUALIZAR);
        }
    }
}
