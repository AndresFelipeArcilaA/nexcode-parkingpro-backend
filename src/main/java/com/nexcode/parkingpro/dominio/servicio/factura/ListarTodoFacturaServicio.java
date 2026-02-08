package com.nexcode.parkingpro.dominio.servicio.factura;

import com.nexcode.parkingpro.dominio.modelo.Factura;
import com.nexcode.parkingpro.dominio.puertos.factura.FacturaPersistencia;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarTodoFacturaServicio {

    private final FacturaPersistencia persistencia;

    public List<Factura> ejecutar() {
        return persistencia.listarTodo();
    }
}
