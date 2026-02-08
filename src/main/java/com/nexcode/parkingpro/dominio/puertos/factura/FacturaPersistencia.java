package com.nexcode.parkingpro.dominio.puertos.factura;

import com.nexcode.parkingpro.dominio.modelo.Factura;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;

public interface FacturaPersistencia {

    Factura guardar(Factura factura);

    Factura buscarPorId(Long id);

    List<Factura> listarTodo();

    void eliminar(Long id);

    void actualizar(Factura factura);


}
