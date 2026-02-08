package com.nexcode.parkingpro.dominio.servicio.factura;

import com.nexcode.parkingpro.dominio.modelo.Factura;
import com.nexcode.parkingpro.dominio.excepcion.ExcepcionRecursoNoEncontrado;
import com.nexcode.parkingpro.dominio.puertos.factura.FacturaPersistencia;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BuscarPorIdFacturaServicio {

    private final FacturaPersistencia persistencia;

    public Factura ejecutar(Long id) {
        return Optional.ofNullable(persistencia.buscarPorId(id))
                .orElseThrow(() ->
                        new ExcepcionRecursoNoEncontrado("No se encontró factura")
                );
    }
}
