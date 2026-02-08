package com.nexcode.parkingpro.dominio.modelo;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    private Long id;

    private String nombre;

    private String correo;

    private String telefono;

    private String contrasena;

}
