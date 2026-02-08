package com.nexcode.parkingpro.dominio.servicio.pagosubscripcion;

import com.nexcode.parkingpro.dominio.modelo.PagoSubscripcion;
import com.nexcode.parkingpro.dominio.puertos.pagosubscripcion.PagoSubscripcionPersistencia;
import com.nexcode.parkingpro.dominio.excepcion.ExcepcionRecursoNoEncontrado;

import java.util.Optional;
import com.nexcode.parkingpro.dominio.puertos.usuario.UsuarioPersistencia;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GuardarPagoSubscripcionServicio {

    private final PagoSubscripcionPersistencia persistencia;

    private final UsuarioPersistencia usuarioPersistencia;

    public PagoSubscripcion ejecutar(PagoSubscripcion pagosubscripcion) {
        validarExistenciaRelaciones(pagosubscripcion);
        return persistencia.guardar(pagosubscripcion);
    }
    private void validarExistenciaRelaciones(PagoSubscripcion pagosubscripcion) {
        Optional.ofNullable(pagosubscripcion.getUsuario())
                .map(relacion -> usuarioPersistencia.buscarPorId(relacion.getId()))
                .orElseThrow(() -> new ExcepcionRecursoNoEncontrado("La entidad Usuario con el ID proporcionado no existe"));

    }
}