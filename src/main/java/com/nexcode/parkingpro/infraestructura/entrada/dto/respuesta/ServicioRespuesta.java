package com.nexcode.parkingpro.infraestructura.entrada.dto.respuesta;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import java.time.LocalDate;
import java.util.List;

import com.nexcode.parkingpro.infraestructura.entrada.dto.respuesta.TipoServicioRespuesta;
import com.nexcode.parkingpro.infraestructura.entrada.dto.respuesta.LugarRespuesta;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServicioRespuesta {

    private Long id;
    private LocalDate fechaHoraIngreso;
    private LocalDate fechaHoraSalida;
    private String placa;
    private String nombreCliente;
    private TipoServicioRespuesta tipoServicio;
    private LugarRespuesta lugar;
}