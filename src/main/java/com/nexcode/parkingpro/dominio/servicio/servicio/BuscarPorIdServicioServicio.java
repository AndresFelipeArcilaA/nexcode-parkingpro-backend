package com.nexcode.parkingpro.dominio.servicio.servicio;

import com.nexcode.parkingpro.dominio.modelo.Servicio;
import com.nexcode.parkingpro.dominio.excepcion.ExcepcionRecursoNoEncontrado;
import com.nexcode.parkingpro.dominio.puertos.servicio.ServicioPersistencia;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BuscarPorIdServicioServicio {

    private final ServicioPersistencia persistencia;

    public Servicio ejecutar(Long id) {
        return Optional.ofNullable(persistencia.buscarPorId(id))
                .orElseThrow(() ->
                        new ExcepcionRecursoNoEncontrado("No se encontró servicio")
                );
    }
}
