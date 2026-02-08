package com.nexcode.parkingpro.infraestructura.salida.mapeador.factura;

import com.nexcode.parkingpro.dominio.modelo.Factura;
import com.nexcode.parkingpro.infraestructura.salida.persistencia.factura.FacturaEntidad;
import com.nexcode.parkingpro.infraestructura.entrada.dto.respuesta.FacturaRespuesta;
import com.nexcode.parkingpro.infraestructura.entrada.dto.solicitud.FacturaSolicitud;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface FacturaMapeador {

    /**
     * Convierte el modelo de dominio (Factura) a la entidad de persistencia (FacturaEntidad).
     * @param modelo El objeto de dominio a mapear.
     * @return La entidad de persistencia mapeada.
     */
    FacturaEntidad aEntidad(Factura modelo);

    /**
     * Convierte la entidad de persistencia (FacturaEntidad) al modelo de dominio (Factura).
     * @param entidad La entidad de persistencia a mapear.
     * @return El objeto de dominio mapeado.
     */
    Factura aDominio(FacturaEntidad entidad);

    /**
     * Convierte el modelo de dominio (Factura) a la respuesta de infraestructura (FacturaRespuesta).
     * @param modelo La entidad de persistencia a mapear.
     * @return El objeto de dominio mapeado.
     */
    FacturaRespuesta aRespuesta(Factura modelo);

    /**
     * Convierte el modelo de solicitud (FacturaSolicitud) al modelo de dominio (Factura).
     * @param solicitud La entidad de persistencia a mapear.
     * @return El objeto de dominio mapeado.
     */
    Factura aDominio(FacturaSolicitud solicitud);
}