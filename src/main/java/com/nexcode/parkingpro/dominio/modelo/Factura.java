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
public class Factura {

    private Long id;

    private Long valorTotal;

    private Servicio servicio;

    private LocalDate fechaHoraEmision;

    private String formaDePago;

}
