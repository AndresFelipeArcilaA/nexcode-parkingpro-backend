package com.nexcode.parkingpro.dominio.servicio.parqueadero;

import com.nexcode.parkingpro.dominio.modelo.Parqueadero;
import com.nexcode.parkingpro.dominio.excepcion.ExcepcionRecursoNoEncontrado;
import com.nexcode.parkingpro.dominio.puertos.parqueadero.ParqueaderoPersistencia;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BuscarPorIdParqueaderoServicio {

    private final ParqueaderoPersistencia persistencia;

    public Parqueadero ejecutar(Long id) {
        return Optional.ofNullable(persistencia.buscarPorId(id))
                .orElseThrow(() ->
                        new ExcepcionRecursoNoEncontrado("No se encontró parqueadero")
                );
    }
}
