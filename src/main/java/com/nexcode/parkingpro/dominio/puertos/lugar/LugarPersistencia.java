package com.nexcode.parkingpro.dominio.puertos.lugar;

import com.nexcode.parkingpro.dominio.modelo.Lugar;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;

public interface LugarPersistencia {

    Lugar guardar(Lugar lugar);

    Lugar buscarPorId(Long id);

    List<Lugar> listarTodo();

    void eliminar(Long id);

    void actualizar(Lugar lugar);


}
