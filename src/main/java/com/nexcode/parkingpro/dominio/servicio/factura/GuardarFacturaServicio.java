package com.nexcode.parkingpro.dominio.servicio.factura;

import com.nexcode.parkingpro.dominio.modelo.Factura;
import com.nexcode.parkingpro.dominio.puertos.factura.FacturaPersistencia;
import com.nexcode.parkingpro.dominio.excepcion.ExcepcionRecursoNoEncontrado;

import java.util.Optional;
import com.nexcode.parkingpro.dominio.puertos.servicio.ServicioPersistencia;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GuardarFacturaServicio {

    private final FacturaPersistencia persistencia;

    private final ServicioPersistencia servicioPersistencia;

    public Factura ejecutar(Factura factura) {
        validarExistenciaRelaciones(factura);
        return persistencia.guardar(factura);
    }
    private void validarExistenciaRelaciones(Factura factura) {
        Optional.ofNullable(factura.getServicio())
                .map(relacion -> servicioPersistencia.buscarPorId(relacion.getId()))
                .orElseThrow(() -> new ExcepcionRecursoNoEncontrado("La entidad Servicio con el ID proporcionado no existe"));

    }
}