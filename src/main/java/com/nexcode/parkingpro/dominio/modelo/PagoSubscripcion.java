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
public class PagoSubscripcion {

    private Long id;

    private Long tipo;

    private LocalDate fechaVencimiento;

    private LocalDate fechaAdquisicion;

    private String estado;

    private Usuario usuario;

}
