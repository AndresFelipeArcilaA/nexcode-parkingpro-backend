package com.nexcode.parkingpro.aplicacion.casodeuso.parqueadero;

import com.nexcode.parkingpro.dominio.modelo.Parqueadero;
import com.nexcode.parkingpro.dominio.servicio.parqueadero.*;

import com.nexcode.parkingpro.dominio.servicio.usuario.BuscarPorIdUsuarioServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;


@Component
@RequiredArgsConstructor
public class ParqueaderoCasoDeUso {

    private final GuardarParqueaderoServicio guardarServicio;
    private final EliminarParqueaderoServicio eliminarServicio;
    private final BuscarPorIdParqueaderoServicio buscarPorIdServicio;
    private final ListarTodoParqueaderoServicio listarTodoServicio;
    private final ActualizarParqueaderoServicio actualizarServicio;
    private final BuscarPorUsuarioServicio buscarPorIdUsuarioServicio;

    public Parqueadero guardarParqueadero(Parqueadero parqueadero) {
        return guardarServicio.ejecutar(parqueadero);
    }

    public void eliminar(Long id) {
        eliminarServicio.ejecutar(id);
    }

    public Parqueadero buscarPorId(Long id) {
        return buscarPorIdServicio.ejecutar(id);
    }

    public List<Parqueadero> listarTodos() {
        return listarTodoServicio.ejecutar();
    }

    public void actualizarParqueadero(Parqueadero parqueadero) {
        actualizarServicio.ejecutar(parqueadero);
    }

    public Parqueadero buscarPorIdUsuario(Long idUsuario) {return buscarPorIdUsuarioServicio.ejecutar(idUsuario);}
}