package com.nexcode.parkingpro.aplicacion.casodeuso.pagosubscripcion;

import com.nexcode.parkingpro.dominio.modelo.PagoSubscripcion;
import com.nexcode.parkingpro.dominio.servicio.pagosubscripcion.GuardarPagoSubscripcionServicio;
import com.nexcode.parkingpro.dominio.servicio.pagosubscripcion.EliminarPagoSubscripcionServicio;
import com.nexcode.parkingpro.dominio.servicio.pagosubscripcion.BuscarPorIdPagoSubscripcionServicio;
import com.nexcode.parkingpro.dominio.servicio.pagosubscripcion.ListarTodoPagoSubscripcionServicio;
import com.nexcode.parkingpro.dominio.servicio.pagosubscripcion.ActualizarPagoSubscripcionServicio;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;


@Component
@RequiredArgsConstructor
public class PagoSubscripcionCasoDeUso {

    private final GuardarPagoSubscripcionServicio guardarServicio;
    private final EliminarPagoSubscripcionServicio eliminarServicio;
    private final BuscarPorIdPagoSubscripcionServicio buscarPorIdServicio;
    private final ListarTodoPagoSubscripcionServicio listarTodoServicio;
    private final ActualizarPagoSubscripcionServicio actualizarServicio;

    public PagoSubscripcion guardarPagoSubscripcion(PagoSubscripcion pagosubscripcion) {
        return guardarServicio.ejecutar(pagosubscripcion);
    }

    public void eliminar(Long id) {
        eliminarServicio.ejecutar(id);
    }

    public PagoSubscripcion buscarPorId(Long id) {
        return buscarPorIdServicio.ejecutar(id);
    }

    public List<PagoSubscripcion> listarTodos() {
        return listarTodoServicio.ejecutar();
    }

    public void actualizarPagoSubscripcion(PagoSubscripcion pagosubscripcion) {
        actualizarServicio.ejecutar(pagosubscripcion);
    }
}