package com.nexcode.parkingpro.infraestructura.salida.mapeador.tiposervicio;

import com.nexcode.parkingpro.dominio.modelo.TipoServicio;
import com.nexcode.parkingpro.infraestructura.salida.persistencia.tiposervicio.TipoServicioEntidad;
import com.nexcode.parkingpro.infraestructura.entrada.dto.respuesta.TipoServicioRespuesta;
import com.nexcode.parkingpro.infraestructura.entrada.dto.solicitud.TipoServicioSolicitud;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TipoServicioMapeador {

    /**
     * Convierte el modelo de dominio (TipoServicio) a la entidad de persistencia (TipoServicioEntidad).
     * @param modelo El objeto de dominio a mapear.
     * @return La entidad de persistencia mapeada.
     */
    TipoServicioEntidad aEntidad(TipoServicio modelo);

    /**
     * Convierte la entidad de persistencia (TipoServicioEntidad) al modelo de dominio (TipoServicio).
     * @param entidad La entidad de persistencia a mapear.
     * @return El objeto de dominio mapeado.
     */
    TipoServicio aDominio(TipoServicioEntidad entidad);

    /**
     * Convierte el modelo de dominio (TipoServicio) a la respuesta de infraestructura (TipoServicioRespuesta).
     * @param modelo La entidad de persistencia a mapear.
     * @return El objeto de dominio mapeado.
     */
    TipoServicioRespuesta aRespuesta(TipoServicio modelo);

    /**
     * Convierte el modelo de solicitud (TipoServicioSolicitud) al modelo de dominio (TipoServicio).
     * @param solicitud La entidad de persistencia a mapear.
     * @return El objeto de dominio mapeado.
     */
    TipoServicio aDominio(TipoServicioSolicitud solicitud);

    List<TipoServicioEntidad> aEntidad(List<TipoServicio> modelo);


}