package com.nexcode.parkingpro.infraestructura.entrada.dto.solicitud;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import java.time.LocalDate;
import java.util.List;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


import com.nexcode.parkingpro.infraestructura.entrada.dto.solicitud.ParqueaderoSolicitud;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LugarSolicitud {

    private Long id;


    private Long piso;


    @NotNull(message = "plaza no puede ser nulo")
    @NotEmpty(message = "plaza no puede estar vacío")
    private String plaza;


    private ParqueaderoSolicitud parqueadero;

}