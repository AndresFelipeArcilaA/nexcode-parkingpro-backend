package com.nexcode.parkingpro.aplicacion.casodeuso.servicio;

import com.nexcode.parkingpro.dominio.modelo.Servicio;
import com.nexcode.parkingpro.dominio.servicio.servicio.GuardarServicioServicio;
import com.nexcode.parkingpro.dominio.servicio.servicio.EliminarServicioServicio;
import com.nexcode.parkingpro.dominio.servicio.servicio.BuscarPorIdServicioServicio;
import com.nexcode.parkingpro.dominio.servicio.servicio.ListarTodoServicioServicio;
import com.nexcode.parkingpro.dominio.servicio.servicio.ActualizarServicioServicio;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;


@Component
@RequiredArgsConstructor
public class ServicioCasoDeUso {

    private final GuardarServicioServicio guardarServicio;
    private final EliminarServicioServicio eliminarServicio;
    private final BuscarPorIdServicioServicio buscarPorIdServicio;
    private final ListarTodoServicioServicio listarTodoServicio;
    private final ActualizarServicioServicio actualizarServicio;

    public Servicio guardarServicio(Servicio servicio) {
        return guardarServicio.ejecutar(servicio);
    }

    public void eliminar(Long id) {
        eliminarServicio.ejecutar(id);
    }

    public Servicio buscarPorId(Long id) {
        return buscarPorIdServicio.ejecutar(id);
    }

    public List<Servicio> listarTodos() {
        return listarTodoServicio.ejecutar();
    }

    public void actualizarServicio(Servicio servicio) {
        actualizarServicio.ejecutar(servicio);
    }
}