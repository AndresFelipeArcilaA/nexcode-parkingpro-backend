package com.nexcode.parkingpro.infraestructura.entrada.dto.solicitud;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import java.time.LocalDate;
import java.util.List;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioSolicitud {

    private Long id;


    @NotNull(message = "nombre no puede ser nulo")
    @NotEmpty(message = "nombre no puede estar vacío")
    private String nombre;


    @NotNull(message = "correo no puede ser nulo")
    @NotEmpty(message = "correo no puede estar vacío")
    private String correo;


    private String telefono;

    @NotNull(message = "la contraseña no puede ser nulo")
    @NotEmpty(message = "la contraseña no puede estar vacío")
    private String contrasena;


}