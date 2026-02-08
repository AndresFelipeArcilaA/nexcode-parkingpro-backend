package com.nexcode.parkingpro.dominio.servicio.tiposervicio;

import com.nexcode.parkingpro.dominio.modelo.TipoServicio;
import com.nexcode.parkingpro.dominio.puertos.tiposervicio.TipoServicioPersistencia;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarTodoTipoServicioServicio {

    private final TipoServicioPersistencia persistencia;

    public List<TipoServicio> ejecutar() {
        return persistencia.listarTodo();
    }
}
