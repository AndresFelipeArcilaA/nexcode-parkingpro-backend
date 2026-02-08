package com.nexcode.parkingpro.aplicacion.casodeuso.tiposervicio;

import com.nexcode.parkingpro.dominio.modelo.TipoServicio;
import com.nexcode.parkingpro.dominio.servicio.tiposervicio.GuardarTipoServicioServicio;
import com.nexcode.parkingpro.dominio.servicio.tiposervicio.EliminarTipoServicioServicio;
import com.nexcode.parkingpro.dominio.servicio.tiposervicio.BuscarPorIdTipoServicioServicio;
import com.nexcode.parkingpro.dominio.servicio.tiposervicio.ListarTodoTipoServicioServicio;
import com.nexcode.parkingpro.dominio.servicio.tiposervicio.ActualizarTipoServicioServicio;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;


@Component
@RequiredArgsConstructor
public class TipoServicioCasoDeUso {

    private final GuardarTipoServicioServicio guardarServicio;
    private final EliminarTipoServicioServicio eliminarServicio;
    private final BuscarPorIdTipoServicioServicio buscarPorIdServicio;
    private final ListarTodoTipoServicioServicio listarTodoServicio;
    private final ActualizarTipoServicioServicio actualizarServicio;

    public TipoServicio guardarTipoServicio(TipoServicio tiposervicio) {
        return guardarServicio.ejecutar(tiposervicio);
    }

    public void eliminar(Long id) {
        eliminarServicio.ejecutar(id);
    }

    public TipoServicio buscarPorId(Long id) {
        return buscarPorIdServicio.ejecutar(id);
    }

    public List<TipoServicio> listarTodos() {
        return listarTodoServicio.ejecutar();
    }

    public void actualizarTipoServicio(TipoServicio tiposervicio) {
        actualizarServicio.ejecutar(tiposervicio);
    }
}