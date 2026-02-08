package com.nexcode.parkingpro.infraestructura.entrada.dto.solicitud;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import java.time.LocalDate;
import java.util.List;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


import com.nexcode.parkingpro.infraestructura.entrada.dto.solicitud.ServicioSolicitud;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FacturaSolicitud {

    private Long id;


    private Long valorTotal;


    private ServicioSolicitud servicio;

    private LocalDate fechaHoraEmision;


    @NotNull(message = "formaDePago no puede ser nulo")
    @NotEmpty(message = "formaDePago no puede estar vacío")
    private String formaDePago;


}