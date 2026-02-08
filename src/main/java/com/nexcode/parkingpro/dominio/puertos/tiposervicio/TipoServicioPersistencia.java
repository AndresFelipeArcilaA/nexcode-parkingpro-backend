package com.nexcode.parkingpro.dominio.puertos.tiposervicio;

import com.nexcode.parkingpro.dominio.modelo.TipoServicio;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;

public interface TipoServicioPersistencia {

    TipoServicio guardar(TipoServicio tiposervicio);

    TipoServicio buscarPorId(Long id);

    List<TipoServicio> listarTodo();

    void eliminar(Long id);

    void actualizar(TipoServicio tiposervicio);

    void guardar(List<TipoServicio> tiposervicio);


}
