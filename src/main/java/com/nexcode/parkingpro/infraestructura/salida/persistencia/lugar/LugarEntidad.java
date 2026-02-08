package com.nexcode.parkingpro.infraestructura.salida.persistencia.lugar;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import com.nexcode.parkingpro.infraestructura.salida.persistencia.parqueadero.ParqueaderoEntidad;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "lugar")
public class LugarEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long piso;

    @Column
    private String plaza;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Parqueadero")
    private ParqueaderoEntidad parqueadero;


}