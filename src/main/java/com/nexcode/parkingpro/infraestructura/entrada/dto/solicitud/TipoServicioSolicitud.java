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
public class TipoServicioSolicitud {

    private Long id;


    @NotNull(message = "tipoVehiculo no puede ser nulo")
    @NotEmpty(message = "tipoVehiculo no puede estar vacío")
    private String tipoVehiculo;


    private Long valor;


    private ParqueaderoSolicitud parqueadero;

}