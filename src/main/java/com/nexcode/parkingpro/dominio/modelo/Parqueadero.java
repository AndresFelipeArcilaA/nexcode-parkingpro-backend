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
public class Parqueadero {

    private Long id;

    private String nombre;

    private String direccion;

    private Long capacidad;

    private Long nit;

    private Usuario usuario;

}
