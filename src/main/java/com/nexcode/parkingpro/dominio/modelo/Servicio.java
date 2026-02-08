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
public class Servicio {

    private Long id;

    private LocalDate fechaHoraIngreso;

    private LocalDate fechaHoraSalida;

    private String placa;

    private String nombreCliente;

    private TipoServicio tipoServicio;

    private Lugar lugar;

}
