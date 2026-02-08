package com.nexcode.parkingpro.dominio.servicio.servicio;

import com.nexcode.parkingpro.dominio.modelo.Servicio;
import com.nexcode.parkingpro.dominio.puertos.servicio.ServicioPersistencia;
import com.nexcode.parkingpro.dominio.excepcion.ExcepcionRecursoNoEncontrado;

import java.util.Optional;
import com.nexcode.parkingpro.dominio.puertos.tiposervicio.TipoServicioPersistencia;
import com.nexcode.parkingpro.dominio.puertos.lugar.LugarPersistencia;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GuardarServicioServicio {

    private final ServicioPersistencia persistencia;

    private final TipoServicioPersistencia tiposervicioPersistencia;
    private final LugarPersistencia lugarPersistencia;

    public Servicio ejecutar(Servicio servicio) {
        validarExistenciaRelaciones(servicio);
        return persistencia.guardar(servicio);
    }
    private void validarExistenciaRelaciones(Servicio servicio) {
        Optional.ofNullable(servicio.getTipoServicio())
                .map(relacion -> tiposervicioPersistencia.buscarPorId(relacion.getId()))
                .orElseThrow(() -> new ExcepcionRecursoNoEncontrado("La entidad TipoServicio con el ID proporcionado no existe"));

        Optional.ofNullable(servicio.getLugar())
                .map(relacion -> lugarPersistencia.buscarPorId(relacion.getId()))
                .orElseThrow(() -> new ExcepcionRecursoNoEncontrado("La entidad Lugar con el ID proporcionado no existe"));

    }
}