package com.nexcode.parkingpro.infraestructura.entrada.controlador.usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import com.nexcode.parkingpro.aplicacion.casodeuso.usuario.UsuarioCasoDeUso;
import com.nexcode.parkingpro.infraestructura.salida.mapeador.usuario.UsuarioMapeador;
import com.nexcode.parkingpro.infraestructura.entrada.dto.solicitud.UsuarioSolicitud;
import com.nexcode.parkingpro.infraestructura.entrada.dto.respuesta.UsuarioRespuesta;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioControlador {

    private final UsuarioCasoDeUso casoDeUso;
    private final UsuarioMapeador mapeador;

    @PostMapping
    public ResponseEntity<UsuarioRespuesta> guardar(@Valid @RequestBody UsuarioSolicitud solicitud) {
        return new ResponseEntity<>(this.mapeador.aRespuesta(
        this.casoDeUso.guardarUsuario(this.mapeador.aDominio(solicitud))), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<UsuarioRespuesta> buscarPorId(@RequestParam Long id) {
        return new ResponseEntity<>(this.mapeador.aRespuesta(
        this.casoDeUso.buscarPorId(id)), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> eliminar(@RequestParam Long id) {
        this.casoDeUso.eliminar(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<List<UsuarioRespuesta>> listarTodos(){
        return new ResponseEntity<>(
        casoDeUso.listarTodos().stream().map(mapeador::aRespuesta).toList(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Void> actualizar(@Valid @RequestBody UsuarioSolicitud solicitud) {
        casoDeUso.actualizarUsuario(mapeador.aDominio(solicitud));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioRespuesta> login(@RequestParam String correo, @RequestParam String contrasena) {
        return new ResponseEntity<>(this.mapeador.aRespuesta(
        this.casoDeUso.iniciarSesion(correo, contrasena)), HttpStatus.OK);
    }
}