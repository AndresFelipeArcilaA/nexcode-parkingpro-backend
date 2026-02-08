package com.nexcode.parkingpro.dominio.servicio.servicio;

import com.nexcode.parkingpro.dominio.modelo.Servicio;
import com.nexcode.parkingpro.dominio.puertos.servicio.ServicioPersistencia;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarTodoServicioServicio {

    private final ServicioPersistencia persistencia;

    public List<Servicio> ejecutar() {
        return persistencia.listarTodo();
    }
}
