package com.nexcode.parkingpro.infraestructura.entrada.controlador.parqueadero;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.nexcode.parkingpro.aplicacion.casodeuso.parqueadero.ParqueaderoCasoDeUso;
import com.nexcode.parkingpro.infraestructura.salida.mapeador.parqueadero.ParqueaderoMapeador;
import com.nexcode.parkingpro.infraestructura.entrada.dto.solicitud.ParqueaderoSolicitud;
import com.nexcode.parkingpro.infraestructura.entrada.dto.respuesta.ParqueaderoRespuesta;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/parqueadero")
@RequiredArgsConstructor
public class ParqueaderoControlador {

    private final ParqueaderoCasoDeUso casoDeUso;
    private final ParqueaderoMapeador mapeador;

    @PostMapping
    public ResponseEntity<ParqueaderoRespuesta> guardar(@Valid @RequestBody ParqueaderoSolicitud solicitud) {
        return new ResponseEntity<>(this.mapeador.aRespuesta(
        this.casoDeUso.guardarParqueadero(this.mapeador.aDominio(solicitud))), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ParqueaderoRespuesta> buscarPorId(@RequestParam Long id) {
        return new ResponseEntity<>(this.mapeador.aRespuesta(
        this.casoDeUso.buscarPorId(id)), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> eliminar(@RequestParam Long id) {
        this.casoDeUso.eliminar(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<List<ParqueaderoRespuesta>> listarTodos(){
        return new ResponseEntity<>(
        casoDeUso.listarTodos().stream().map(mapeador::aRespuesta).toList(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> actualizar(@Valid @RequestBody ParqueaderoSolicitud solicitud) {
        casoDeUso.actualizarParqueadero(mapeador.aDominio(solicitud));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/buscar-por-usuario")
    public ResponseEntity<ParqueaderoRespuesta> buscarPorIdUsuario(@RequestParam Long idUsuario) {
        return new ResponseEntity<>(this.mapeador.aRespuesta(
                this.casoDeUso.buscarPorIdUsuario(idUsuario)), HttpStatus.OK);
    }
}