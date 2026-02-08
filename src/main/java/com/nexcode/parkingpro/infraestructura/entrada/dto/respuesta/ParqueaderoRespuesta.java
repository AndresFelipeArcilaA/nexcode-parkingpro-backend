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
public class ParqueaderoRespuesta {

    private Long id;
    private String nombre;
    private String direccion;
    private Long capacidad;
    private Long nit;
    private UsuarioRespuesta usuario;
}