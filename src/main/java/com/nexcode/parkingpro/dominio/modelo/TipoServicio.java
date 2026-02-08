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
public class TipoServicio {

    private Long id;

    private String tipoVehiculo;

    private Long valor;

    private Parqueadero parqueadero;

}
