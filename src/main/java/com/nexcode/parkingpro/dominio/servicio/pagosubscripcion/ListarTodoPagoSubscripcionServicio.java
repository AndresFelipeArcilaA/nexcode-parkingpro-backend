package com.nexcode.parkingpro.dominio.servicio.pagosubscripcion;

import com.nexcode.parkingpro.dominio.modelo.PagoSubscripcion;
import com.nexcode.parkingpro.dominio.puertos.pagosubscripcion.PagoSubscripcionPersistencia;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarTodoPagoSubscripcionServicio {

    private final PagoSubscripcionPersistencia persistencia;

    public List<PagoSubscripcion> ejecutar() {
        return persistencia.listarTodo();
    }
}
