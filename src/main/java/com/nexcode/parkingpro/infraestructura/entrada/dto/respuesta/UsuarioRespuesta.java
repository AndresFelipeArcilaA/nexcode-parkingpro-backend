package com.nexcode.parkingpro.infraestructura.entrada.dto.respuesta;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import java.time.LocalDate;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRespuesta {

    private Long id;
    private String nombre;
    private String correo;
    private String telefono;
    private String contrasena;
}