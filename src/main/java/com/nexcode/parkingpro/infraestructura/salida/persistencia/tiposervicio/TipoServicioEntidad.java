package com.nexcode.parkingpro.infraestructura.salida.persistencia.tiposervicio;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import com.nexcode.parkingpro.infraestructura.salida.persistencia.parqueadero.ParqueaderoEntidad;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "tiposervicio")
public class TipoServicioEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipoVehiculo;

    @Column
    private Long valor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Parqueadero")
    private ParqueaderoEntidad parqueadero;


}