package com.nexcode.parkingpro.infraestructura.salida.mapeador.parqueadero;

import com.nexcode.parkingpro.dominio.modelo.Parqueadero;
import com.nexcode.parkingpro.infraestructura.salida.persistencia.parqueadero.ParqueaderoEntidad;
import com.nexcode.parkingpro.infraestructura.entrada.dto.respuesta.ParqueaderoRespuesta;
import com.nexcode.parkingpro.infraestructura.entrada.dto.solicitud.ParqueaderoSolicitud;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ParqueaderoMapeador {

    /**
     * Convierte el modelo de dominio (Parqueadero) a la entidad de persistencia (ParqueaderoEntidad).
     * @param modelo El objeto de dominio a mapear.
     * @return La entidad de persistencia mapeada.
     */
    ParqueaderoEntidad aEntidad(Parqueadero modelo);

    /**
     * Convierte la entidad de persistencia (ParqueaderoEntidad) al modelo de dominio (Parqueadero).
     * @param entidad La entidad de persistencia a mapear.
     * @return El objeto de dominio mapeado.
     */
    Parqueadero aDominio(ParqueaderoEntidad entidad);

    /**
     * Convierte el modelo de dominio (Parqueadero) a la respuesta de infraestructura (ParqueaderoRespuesta).
     * @param modelo La entidad de persistencia a mapear.
     * @return El objeto de dominio mapeado.
     */
    ParqueaderoRespuesta aRespuesta(Parqueadero modelo);

    /**
     * Convierte el modelo de solicitud (ParqueaderoSolicitud) al modelo de dominio (Parqueadero).
     * @param solicitud La entidad de persistencia a mapear.
     * @return El objeto de dominio mapeado.
     */
    Parqueadero aDominio(ParqueaderoSolicitud solicitud);
}