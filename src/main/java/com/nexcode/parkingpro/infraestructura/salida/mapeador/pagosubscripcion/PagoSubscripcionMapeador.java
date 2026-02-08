package com.nexcode.parkingpro.infraestructura.salida.mapeador.pagosubscripcion;

import com.nexcode.parkingpro.dominio.modelo.PagoSubscripcion;
import com.nexcode.parkingpro.infraestructura.salida.persistencia.pagosubscripcion.PagoSubscripcionEntidad;
import com.nexcode.parkingpro.infraestructura.entrada.dto.respuesta.PagoSubscripcionRespuesta;
import com.nexcode.parkingpro.infraestructura.entrada.dto.solicitud.PagoSubscripcionSolicitud;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PagoSubscripcionMapeador {

    /**
     * Convierte el modelo de dominio (PagoSubscripcion) a la entidad de persistencia (PagoSubscripcionEntidad).
     * @param modelo El objeto de dominio a mapear.
     * @return La entidad de persistencia mapeada.
     */
    PagoSubscripcionEntidad aEntidad(PagoSubscripcion modelo);

    /**
     * Convierte la entidad de persistencia (PagoSubscripcionEntidad) al modelo de dominio (PagoSubscripcion).
     * @param entidad La entidad de persistencia a mapear.
     * @return El objeto de dominio mapeado.
     */
    PagoSubscripcion aDominio(PagoSubscripcionEntidad entidad);

    /**
     * Convierte el modelo de dominio (PagoSubscripcion) a la respuesta de infraestructura (PagoSubscripcionRespuesta).
     * @param modelo La entidad de persistencia a mapear.
     * @return El objeto de dominio mapeado.
     */
    PagoSubscripcionRespuesta aRespuesta(PagoSubscripcion modelo);

    /**
     * Convierte el modelo de solicitud (PagoSubscripcionSolicitud) al modelo de dominio (PagoSubscripcion).
     * @param solicitud La entidad de persistencia a mapear.
     * @return El objeto de dominio mapeado.
     */
    PagoSubscripcion aDominio(PagoSubscripcionSolicitud solicitud);
}