package com.nexcode.parkingpro.infraestructura.entrada.dto.solicitud;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import java.time.LocalDate;
import java.util.List;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


import com.nexcode.parkingpro.infraestructura.entrada.dto.solicitud.UsuarioSolicitud;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PagoSubscripcionSolicitud {

    private Long id;


    private Long tipo;


    private LocalDate fechaVencimiento;


    private LocalDate fechaAdquisicion;


    @NotNull(message = "estado no puede ser nulo")
    @NotEmpty(message = "estado no puede estar vacío")
    private String estado;


    private UsuarioSolicitud usuario;

}