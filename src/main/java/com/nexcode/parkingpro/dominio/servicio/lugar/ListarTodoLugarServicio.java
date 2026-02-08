package com.nexcode.parkingpro.dominio.servicio.lugar;

import com.nexcode.parkingpro.dominio.modelo.Lugar;
import com.nexcode.parkingpro.dominio.puertos.lugar.LugarPersistencia;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarTodoLugarServicio {

    private final LugarPersistencia persistencia;

    public List<Lugar> ejecutar() {
        return persistencia.listarTodo();
    }
}
