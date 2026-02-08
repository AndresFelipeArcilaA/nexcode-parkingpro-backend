package com.nexcode.parkingpro.infraestructura.salida.persistencia.factura;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import com.nexcode.parkingpro.infraestructura.salida.persistencia.servicio.ServicioEntidad;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "factura")
public class FacturaEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long valorTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Servicio")
    private ServicioEntidad servicio;


    @Column
    private LocalDate fechaHoraEmision;

    @Column
    private String formaDePago;

}