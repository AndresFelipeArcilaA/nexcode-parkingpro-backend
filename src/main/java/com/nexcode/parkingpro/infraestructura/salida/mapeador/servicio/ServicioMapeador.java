package com.nexcode.parkingpro.infraestructura.salida.mapeador.servicio;

import com.nexcode.parkingpro.dominio.modelo.Servicio;
import com.nexcode.parkingpro.infraestructura.salida.persistencia.servicio.ServicioEntidad;
import com.nexcode.parkingpro.infraestructura.entrada.dto.respuesta.ServicioRespuesta;
import com.nexcode.parkingpro.infraestructura.entrada.dto.solicitud.ServicioSolicitud;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ServicioMapeador {

    /**
     * Convierte el modelo de dominio (Servicio) a la entidad de persistencia (ServicioEntidad).
     * @param modelo El objeto de dominio a mapear.
     * @return La entidad de persistencia mapeada.
     */
    ServicioEntidad aEntidad(Servicio modelo);

    /**
     * Convierte la entidad de persistencia (ServicioEntidad) al modelo de dominio (Servicio).
     * @param entidad La entidad de persistencia a mapear.
     * @return El objeto de dominio mapeado.
     */
    Servicio aDominio(ServicioEntidad entidad);

    /**
     * Convierte el modelo de dominio (Servicio) a la respuesta de infraestructura (ServicioRespuesta).
     * @param modelo La entidad de persistencia a mapear.
     * @return El objeto de dominio mapeado.
     */
    ServicioRespuesta aRespuesta(Servicio modelo);

    /**
     * Convierte el modelo de solicitud (ServicioSolicitud) al modelo de dominio (Servicio).
     * @param solicitud La entidad de persistencia a mapear.
     * @return El objeto de dominio mapeado.
     */
    Servicio aDominio(ServicioSolicitud solicitud);
}