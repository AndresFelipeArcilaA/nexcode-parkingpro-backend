package com.nexcode.parkingpro.dominio.excepcion;

public abstract class ExcepcionDominio extends RuntimeException {

    protected ExcepcionDominio(String mensaje) {
        super(mensaje);
    }
}
