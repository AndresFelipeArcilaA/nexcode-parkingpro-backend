package com.nexcode.parkingpro.dominio.servicio.lugar;

import com.nexcode.parkingpro.dominio.modelo.Lugar;
import com.nexcode.parkingpro.dominio.puertos.lugar.LugarPersistencia;
import com.nexcode.parkingpro.dominio.excepcion.ExcepcionRecursoNoEncontrado;

import java.util.Optional;
import com.nexcode.parkingpro.dominio.puertos.parqueadero.ParqueaderoPersistencia;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GuardarLugarServicio {

    private final LugarPersistencia persistencia;

    private final ParqueaderoPersistencia parqueaderoPersistencia;

    public Lugar ejecutar(Lugar lugar) {
        validarExistenciaRelaciones(lugar);
        return persistencia.guardar(lugar);
    }
    private void validarExistenciaRelaciones(Lugar lugar) {
        Optional.ofNullable(lugar.getParqueadero())
                .map(relacion -> parqueaderoPersistencia.buscarPorId(relacion.getId()))
                .orElseThrow(() -> new ExcepcionRecursoNoEncontrado("La entidad Parqueadero con el ID proporcionado no existe"));

    }
}