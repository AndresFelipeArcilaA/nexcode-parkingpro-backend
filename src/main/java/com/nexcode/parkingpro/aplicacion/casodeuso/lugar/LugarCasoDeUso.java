package com.nexcode.parkingpro.aplicacion.casodeuso.lugar;

import com.nexcode.parkingpro.dominio.modelo.Lugar;
import com.nexcode.parkingpro.dominio.servicio.lugar.GuardarLugarServicio;
import com.nexcode.parkingpro.dominio.servicio.lugar.EliminarLugarServicio;
import com.nexcode.parkingpro.dominio.servicio.lugar.BuscarPorIdLugarServicio;
import com.nexcode.parkingpro.dominio.servicio.lugar.ListarTodoLugarServicio;
import com.nexcode.parkingpro.dominio.servicio.lugar.ActualizarLugarServicio;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;


@Component
@RequiredArgsConstructor
public class LugarCasoDeUso {

    private final GuardarLugarServicio guardarServicio;
    private final EliminarLugarServicio eliminarServicio;
    private final BuscarPorIdLugarServicio buscarPorIdServicio;
    private final ListarTodoLugarServicio listarTodoServicio;
    private final ActualizarLugarServicio actualizarServicio;

    public Lugar guardarLugar(Lugar lugar) {
        return guardarServicio.ejecutar(lugar);
    }

    public void eliminar(Long id) {
        eliminarServicio.ejecutar(id);
    }

    public Lugar buscarPorId(Long id) {
        return buscarPorIdServicio.ejecutar(id);
    }

    public List<Lugar> listarTodos() {
        return listarTodoServicio.ejecutar();
    }

    public void actualizarLugar(Lugar lugar) {
        actualizarServicio.ejecutar(lugar);
    }
}