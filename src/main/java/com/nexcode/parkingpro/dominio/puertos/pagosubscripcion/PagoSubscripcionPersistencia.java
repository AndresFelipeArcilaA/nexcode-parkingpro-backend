package com.nexcode.parkingpro.dominio.puertos.pagosubscripcion;

import com.nexcode.parkingpro.dominio.modelo.PagoSubscripcion;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;

public interface PagoSubscripcionPersistencia {

    PagoSubscripcion guardar(PagoSubscripcion pagosubscripcion);

    PagoSubscripcion buscarPorId(Long id);

    List<PagoSubscripcion> listarTodo();

    void eliminar(Long id);

    void actualizar(PagoSubscripcion pagosubscripcion);


}
