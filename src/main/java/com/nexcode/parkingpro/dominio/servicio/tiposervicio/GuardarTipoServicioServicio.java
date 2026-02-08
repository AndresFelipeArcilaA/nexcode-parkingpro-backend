package com.nexcode.parkingpro.dominio.servicio.tiposervicio;

import com.nexcode.parkingpro.dominio.modelo.TipoServicio;
import com.nexcode.parkingpro.dominio.puertos.tiposervicio.TipoServicioPersistencia;
import com.nexcode.parkingpro.dominio.excepcion.ExcepcionRecursoNoEncontrado;

import java.util.Optional;
import com.nexcode.parkingpro.dominio.puertos.parqueadero.ParqueaderoPersistencia;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GuardarTipoServicioServicio {

    private final TipoServicioPersistencia persistencia;

    private final ParqueaderoPersistencia parqueaderoPersistencia;

    public TipoServicio ejecutar(TipoServicio tiposervicio) {
        validarExistenciaRelaciones(tiposervicio);
        return persistencia.guardar(tiposervicio);
    }
    private void validarExistenciaRelaciones(TipoServicio tiposervicio) {
        Optional.ofNullable(tiposervicio.getParqueadero())
                .map(relacion -> parqueaderoPersistencia.buscarPorId(relacion.getId()))
                .orElseThrow(() -> new ExcepcionRecursoNoEncontrado("La entidad Parqueadero con el ID proporcionado no existe"));

    }
}