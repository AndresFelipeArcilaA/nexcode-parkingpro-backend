package com.nexcode.parkingpro.infraestructura.entrada.dto.respuesta;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import java.time.LocalDate;
import java.util.List;

import com.nexcode.parkingpro.infraestructura.entrada.dto.respuesta.UsuarioRespuesta;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PagoSubscripcionRespuesta {

    private Long id;
    private Long tipo;
    private LocalDate fechaVencimiento;
    private LocalDate fechaAdquisicion;
    private String estado;
    private UsuarioRespuesta usuario;
}