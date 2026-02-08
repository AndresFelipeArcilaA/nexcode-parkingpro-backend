package com.nexcode.parkingpro.dominio.servicio.lugar;

import com.nexcode.parkingpro.dominio.modelo.Lugar;
import com.nexcode.parkingpro.dominio.excepcion.ExcepcionRecursoNoEncontrado;
import com.nexcode.parkingpro.dominio.puertos.lugar.LugarPersistencia;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BuscarPorIdLugarServicio {

    private final LugarPersistencia persistencia;

    public Lugar ejecutar(Long id) {
        return Optional.ofNullable(persistencia.buscarPorId(id))
                .orElseThrow(() ->
                        new ExcepcionRecursoNoEncontrado("No se encontró lugar")
                );
    }
}
