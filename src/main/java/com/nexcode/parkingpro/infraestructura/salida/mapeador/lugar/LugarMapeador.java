package com.nexcode.parkingpro.infraestructura.salida.mapeador.lugar;

import com.nexcode.parkingpro.dominio.modelo.Lugar;
import com.nexcode.parkingpro.infraestructura.salida.persistencia.lugar.LugarEntidad;
import com.nexcode.parkingpro.infraestructura.entrada.dto.respuesta.LugarRespuesta;
import com.nexcode.parkingpro.infraestructura.entrada.dto.solicitud.LugarSolicitud;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface LugarMapeador {

    /**
     * Convierte el modelo de dominio (Lugar) a la entidad de persistencia (LugarEntidad).
     * @param modelo El objeto de dominio a mapear.
     * @return La entidad de persistencia mapeada.
     */
    LugarEntidad aEntidad(Lugar modelo);

    /**
     * Convierte la entidad de persistencia (LugarEntidad) al modelo de dominio (Lugar).
     * @param entidad La entidad de persistencia a mapear.
     * @return El objeto de dominio mapeado.
     */
    Lugar aDominio(LugarEntidad entidad);

    /**
     * Convierte el modelo de dominio (Lugar) a la respuesta de infraestructura (LugarRespuesta).
     * @param modelo La entidad de persistencia a mapear.
     * @return El objeto de dominio mapeado.
     */
    LugarRespuesta aRespuesta(Lugar modelo);

    /**
     * Convierte el modelo de solicitud (LugarSolicitud) al modelo de dominio (Lugar).
     * @param solicitud La entidad de persistencia a mapear.
     * @return El objeto de dominio mapeado.
     */
    Lugar aDominio(LugarSolicitud solicitud);
}