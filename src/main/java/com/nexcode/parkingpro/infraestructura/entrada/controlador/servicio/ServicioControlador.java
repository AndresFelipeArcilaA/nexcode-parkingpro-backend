package com.nexcode.parkingpro.infraestructura.entrada.controlador.servicio;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.nexcode.parkingpro.aplicacion.casodeuso.servicio.ServicioCasoDeUso;
import com.nexcode.parkingpro.infraestructura.salida.mapeador.servicio.ServicioMapeador;
import com.nexcode.parkingpro.infraestructura.entrada.dto.solicitud.ServicioSolicitud;
import com.nexcode.parkingpro.infraestructura.entrada.dto.respuesta.ServicioRespuesta;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/servicio")
@RequiredArgsConstructor
public class ServicioControlador {

    private final ServicioCasoDeUso casoDeUso;
    private final ServicioMapeador mapeador;

    @PostMapping
    public ResponseEntity<ServicioRespuesta> guardar(@Valid @RequestBody ServicioSolicitud solicitud) {
        return new ResponseEntity<>(this.mapeador.aRespuesta(
        this.casoDeUso.guardarServicio(this.mapeador.aDominio(solicitud))), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ServicioRespuesta> buscarPorId(@RequestParam Long id) {
        return new ResponseEntity<>(this.mapeador.aRespuesta(
        this.casoDeUso.buscarPorId(id)), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> eliminar(@RequestParam Long id) {
        this.casoDeUso.eliminar(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<List<ServicioRespuesta>> listarTodos(){
        return new ResponseEntity<>(
        casoDeUso.listarTodos().stream().map(mapeador::aRespuesta).toList(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> actualizar(@Valid @RequestBody ServicioSolicitud solicitud) {
        casoDeUso.actualizarServicio(mapeador.aDominio(solicitud));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}