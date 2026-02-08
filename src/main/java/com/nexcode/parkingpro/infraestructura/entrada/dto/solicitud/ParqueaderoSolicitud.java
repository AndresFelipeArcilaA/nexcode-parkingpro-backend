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
public class ParqueaderoSolicitud {

    private Long id;


    @NotNull(message = "nombre no puede ser nulo")
    @NotEmpty(message = "nombre no puede estar vacío")
    private String nombre;


    @NotNull(message = "direccion no puede ser nulo")
    @NotEmpty(message = "direccion no puede estar vacío")
    private String direccion;


    private Long capacidad;


    private Long nit;


    private UsuarioSolicitud usuario;

}