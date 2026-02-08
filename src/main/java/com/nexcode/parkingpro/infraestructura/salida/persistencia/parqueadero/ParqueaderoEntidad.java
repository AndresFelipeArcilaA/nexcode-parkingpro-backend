package com.nexcode.parkingpro.infraestructura.salida.persistencia.parqueadero;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import com.nexcode.parkingpro.infraestructura.salida.persistencia.usuario.UsuarioEntidad;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "parqueadero")
public class ParqueaderoEntidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    @Column
    private Long capacidad;

    @Column
    private Long nit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Usuario")
    private UsuarioEntidad usuario;


}