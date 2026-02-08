package com.nexcode.parkingpro.dominio.puertos.servicio;

import com.nexcode.parkingpro.dominio.modelo.Servicio;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;

public interface ServicioPersistencia {

    Servicio guardar(Servicio servicio);

    Servicio buscarPorId(Long id);

    List<Servicio> listarTodo();

    void eliminar(Long id);

    void actualizar(Servicio servicio);


}
