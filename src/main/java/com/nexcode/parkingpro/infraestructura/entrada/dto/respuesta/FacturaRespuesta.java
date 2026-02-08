package com.nexcode.parkingpro.infraestructura.entrada.dto.respuesta;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import java.time.LocalDate;
import java.util.List;

import com.nexcode.parkingpro.infraestructura.entrada.dto.respuesta.ServicioRespuesta;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FacturaRespuesta {

    private Long id;
    private Long valorTotal;
    private ServicioRespuesta servicio;
    private LocalDate fechaHoraEmision;
    private String formaDePago;
}