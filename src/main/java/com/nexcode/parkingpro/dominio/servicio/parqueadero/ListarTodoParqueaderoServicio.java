package com.nexcode.parkingpro.dominio.servicio.parqueadero;

import com.nexcode.parkingpro.dominio.modelo.Parqueadero;
import com.nexcode.parkingpro.dominio.puertos.parqueadero.ParqueaderoPersistencia;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarTodoParqueaderoServicio {

    private final ParqueaderoPersistencia persistencia;

    public List<Parqueadero> ejecutar() {
        return persistencia.listarTodo();
    }
}
