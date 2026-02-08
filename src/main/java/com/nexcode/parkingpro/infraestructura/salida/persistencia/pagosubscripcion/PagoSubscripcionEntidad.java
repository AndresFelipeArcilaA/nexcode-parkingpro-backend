package com.nexcode.parkingpro.infraestructura.salida.persistencia.pagosubscripcion;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import com.nexcode.parkingpro.infraestructura.salida.persistencia.usuario.UsuarioEntidad;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "pagosubscripcion")
public class PagoSubscripcionEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long tipo;

    @Column
    private LocalDate fechaVencimiento;

    @Column
    private LocalDate fechaAdquisicion;

    @Column
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Usuario")
    private UsuarioEntidad usuario;


}