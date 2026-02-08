package com.nexcode.parkingpro.infraestructura.entrada.comun;

import com.nexcode.parkingpro.dominio.excepcion.ExcepcionDominio;
import com.nexcode.parkingpro.dominio.excepcion.ExcepcionRecursoNoEncontrado;
import com.nexcode.parkingpro.infraestructura.entrada.dto.error.RespuestaError;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class ManejadorGlobalDeErrores {

    private static final Logger log =
            LoggerFactory.getLogger(ManejadorGlobalDeErrores.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RespuestaError> manejarValidaciones(MethodArgumentNotValidException ex) {

        String mensaje = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .findFirst()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .orElse("Error de validación");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new RespuestaError(mensaje));
    }

    @ExceptionHandler(ExcepcionRecursoNoEncontrado.class)
    public ResponseEntity<RespuestaError> manejarRecursoNoEncontrado(ExcepcionRecursoNoEncontrado ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new RespuestaError(ex.getMessage()));
    }

    @ExceptionHandler(ExcepcionDominio.class)
    public ResponseEntity<RespuestaError> manejarErrorDeDominio(ExcepcionDominio ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new RespuestaError(ex.getMessage()));
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<RespuestaError> manejarRutaNoExiste(NoHandlerFoundException ex) {

        log.warn("Ruta REST inexistente: {} {}", ex.getHttpMethod(), ex.getRequestURL());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new RespuestaError("La dirección solicitada no existe"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RespuestaError> manejarErrorGeneral(Exception ex) {

        log.error("Error técnico no controlado", ex);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new RespuestaError("Error interno del servidor"));
    }
}