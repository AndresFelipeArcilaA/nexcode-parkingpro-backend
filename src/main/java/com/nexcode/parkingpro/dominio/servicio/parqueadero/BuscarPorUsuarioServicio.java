package com.nexcode.parkingpro.dominio.servicio.parqueadero;

import com.nexcode.parkingpro.dominio.modelo.Parqueadero;
import com.nexcode.parkingpro.dominio.puertos.parqueadero.ParqueaderoPersistencia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BuscarPorUsuarioServicio {

    private final ParqueaderoPersistencia persistencia;

    public Parqueadero ejecutar(Long idUsuario) {
        return persistencia.buscarPorIdUsuario(idUsuario);
    }
}
