package com.nexcode.parkingpro.infraestructura.entrada.dto.solicitud;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import java.time.LocalDate;
import java.util.List;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


import com.nexcode.parkingpro.infraestructura.entrada.dto.solicitud.TipoServicioSolicitud;
import com.nexcode.parkingpro.infraestructura.entrada.dto.solicitud.LugarSolicitud;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServicioSolicitud {

    private Long id;


    private LocalDate fechaHoraIngreso;


    private LocalDate fechaHoraSalida;


    @NotNull(message = "placa no puede ser nulo")
    @NotEmpty(message = "placa no puede estar vacío")
    private String placa;


    @NotNull(message = "nombreCliente no puede ser nulo")
    @NotEmpty(message = "nombreCliente no puede estar vacío")
    private String nombreCliente;


    private TipoServicioSolicitud tipoServicio;

    private LugarSolicitud lugar;

}