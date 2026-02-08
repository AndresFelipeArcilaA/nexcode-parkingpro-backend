package com.nexcode.parkingpro.dominio.puertos.parqueadero;

import com.nexcode.parkingpro.dominio.modelo.Parqueadero;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;

public interface ParqueaderoPersistencia {

    Parqueadero guardar(Parqueadero parqueadero);

    Parqueadero buscarPorId(Long id);

    List<Parqueadero> listarTodo();

    void eliminar(Long id);

    void actualizar(Parqueadero parqueadero);

    Parqueadero buscarPorIdUsuario(Long idUsuario);


}
