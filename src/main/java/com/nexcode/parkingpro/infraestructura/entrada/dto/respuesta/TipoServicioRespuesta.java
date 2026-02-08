package com.nexcode.parkingpro.infraestructura.entrada.dto.respuesta;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import java.time.LocalDate;
import java.util.List;

import com.nexcode.parkingpro.infraestructura.entrada.dto.respuesta.ParqueaderoRespuesta;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoServicioRespuesta {

    private Long id;
    private String tipoVehiculo;
    private Long valor;
    private ParqueaderoRespuesta parqueadero;
}