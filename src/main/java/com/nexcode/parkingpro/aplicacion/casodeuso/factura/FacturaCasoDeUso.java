package com.nexcode.parkingpro.aplicacion.casodeuso.factura;

import com.nexcode.parkingpro.dominio.modelo.Factura;
import com.nexcode.parkingpro.dominio.servicio.factura.GuardarFacturaServicio;
import com.nexcode.parkingpro.dominio.servicio.factura.EliminarFacturaServicio;
import com.nexcode.parkingpro.dominio.servicio.factura.BuscarPorIdFacturaServicio;
import com.nexcode.parkingpro.dominio.servicio.factura.ListarTodoFacturaServicio;
import com.nexcode.parkingpro.dominio.servicio.factura.ActualizarFacturaServicio;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;


@Component
@RequiredArgsConstructor
public class FacturaCasoDeUso {

    private final GuardarFacturaServicio guardarServicio;
    private final EliminarFacturaServicio eliminarServicio;
    private final BuscarPorIdFacturaServicio buscarPorIdServicio;
    private final ListarTodoFacturaServicio listarTodoServicio;
    private final ActualizarFacturaServicio actualizarServicio;

    public Factura guardarFactura(Factura factura) {
        return guardarServicio.ejecutar(factura);
    }

    public void eliminar(Long id) {
        eliminarServicio.ejecutar(id);
    }

    public Factura buscarPorId(Long id) {
        return buscarPorIdServicio.ejecutar(id);
    }

    public List<Factura> listarTodos() {
        return listarTodoServicio.ejecutar();
    }

    public void actualizarFactura(Factura factura) {
        actualizarServicio.ejecutar(factura);
    }
}