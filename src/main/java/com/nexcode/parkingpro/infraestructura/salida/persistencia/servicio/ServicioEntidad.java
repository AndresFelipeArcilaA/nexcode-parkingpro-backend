package com.nexcode.parkingpro.infraestructura.salida.persistencia.servicio;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import com.nexcode.parkingpro.infraestructura.salida.persistencia.tiposervicio.TipoServicioEntidad;
import com.nexcode.parkingpro.infraestructura.salida.persistencia.lugar.LugarEntidad;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "servicio")
public class ServicioEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fechaHoraIngreso;

    @Column
    private LocalDate fechaHoraSalida;

    @Column(nullable = false)
    private String placa;

    @Column
    private String nombreCliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TipoServicio")
    private TipoServicioEntidad tipoServicio;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Lugar")
    private LugarEntidad lugar;


}