package com.nexcode.parkingpro.infraestructura.entrada.controlador.tiposervicio;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.nexcode.parkingpro.aplicacion.casodeuso.tiposervicio.TipoServicioCasoDeUso;
import com.nexcode.parkingpro.infraestructura.salida.mapeador.tiposervicio.TipoServicioMapeador;
import com.nexcode.parkingpro.infraestructura.entrada.dto.solicitud.TipoServicioSolicitud;
import com.nexcode.parkingpro.infraestructura.entrada.dto.respuesta.TipoServicioRespuesta;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tiposervicio")
@RequiredArgsConstructor
public class TipoServicioControlador {

    private final TipoServicioCasoDeUso casoDeUso;
    private final TipoServicioMapeador mapeador;

    @PostMapping
    public ResponseEntity<TipoServicioRespuesta> guardar(@Valid @RequestBody TipoServicioSolicitud solicitud) {
        return new ResponseEntity<>(this.mapeador.aRespuesta(
        this.casoDeUso.guardarTipoServicio(this.mapeador.aDominio(solicitud))), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<TipoServicioRespuesta> buscarPorId(@RequestParam Long id) {
        return new ResponseEntity<>(this.mapeador.aRespuesta(
        this.casoDeUso.buscarPorId(id)), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> eliminar(@RequestParam Long id) {
        this.casoDeUso.eliminar(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<List<TipoServicioRespuesta>> listarTodos(){
        return new ResponseEntity<>(
        casoDeUso.listarTodos().stream().map(mapeador::aRespuesta).toList(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> actualizar(@Valid @RequestBody TipoServicioSolicitud solicitud) {
        casoDeUso.actualizarTipoServicio(mapeador.aDominio(solicitud));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}