package com.nexcode.parkingpro.dominio.servicio.parqueadero;

import com.nexcode.parkingpro.dominio.modelo.Parqueadero;
import com.nexcode.parkingpro.dominio.modelo.TipoServicio;
import com.nexcode.parkingpro.dominio.puertos.parqueadero.ParqueaderoPersistencia;
import com.nexcode.parkingpro.dominio.puertos.tiposervicio.TipoServicioPersistencia;
import com.nexcode.parkingpro.dominio.excepcion.ExcepcionRecursoNoEncontrado;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.nexcode.parkingpro.dominio.puertos.usuario.UsuarioPersistencia;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GuardarParqueaderoServicio {

    private final ParqueaderoPersistencia persistencia;
    private final UsuarioPersistencia usuarioPersistencia;
    private final TipoServicioPersistencia tipoServicioPersistencia;

    public Parqueadero ejecutar(Parqueadero parqueadero) {
        validarExistenciaRelaciones(parqueadero);
        Parqueadero parqueaderoGuardado = persistencia.guardar(parqueadero);
        crearTiposServicioPorDefecto(parqueaderoGuardado);
        return parqueaderoGuardado;
    }

    private void validarExistenciaRelaciones(Parqueadero parqueadero) {
        Optional.ofNullable(parqueadero.getUsuario())
                .map(relacion -> usuarioPersistencia.buscarPorId(relacion.getId()))
                .orElseThrow(() -> new ExcepcionRecursoNoEncontrado("La entidad Usuario con el ID proporcionado no existe"));
    }

    private void crearTiposServicioPorDefecto(Parqueadero parqueadero) {
        List<TipoServicio> tipoServicios = new ArrayList<>();
        TipoServicio tipoAuto = TipoServicio.builder()
                .tipoVehiculo("Auto")
                .valor(0L)
                .parqueadero(parqueadero)
                .build();

        TipoServicio tipoMoto = TipoServicio.builder()
                .tipoVehiculo("Moto")
                .valor(0L)
                .parqueadero(parqueadero)
                .build();

        TipoServicio tipoPesado = TipoServicio.builder()
                .tipoVehiculo("Pesado")
                .valor(0L)
                .parqueadero(parqueadero)
                .build();

        tipoServicios.add(tipoAuto);
        tipoServicios.add(tipoMoto);
        tipoServicios.add(tipoPesado);

        tipoServicioPersistencia.guardar(tipoServicios);
        
    }
}