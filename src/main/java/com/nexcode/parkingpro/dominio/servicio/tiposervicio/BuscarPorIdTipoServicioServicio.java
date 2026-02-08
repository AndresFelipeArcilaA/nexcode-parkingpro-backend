package com.nexcode.parkingpro.dominio.servicio.tiposervicio;

import com.nexcode.parkingpro.dominio.modelo.TipoServicio;
import com.nexcode.parkingpro.dominio.excepcion.ExcepcionRecursoNoEncontrado;
import com.nexcode.parkingpro.dominio.puertos.tiposervicio.TipoServicioPersistencia;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BuscarPorIdTipoServicioServicio {

    private final TipoServicioPersistencia persistencia;

    public TipoServicio ejecutar(Long id) {
        return Optional.ofNullable(persistencia.buscarPorId(id))
                .orElseThrow(() ->
                        new ExcepcionRecursoNoEncontrado("No se encontró tiposervicio")
                );
    }
}
