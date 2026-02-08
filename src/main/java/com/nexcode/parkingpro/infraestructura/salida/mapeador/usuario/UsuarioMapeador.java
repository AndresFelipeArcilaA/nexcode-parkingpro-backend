package com.nexcode.parkingpro.infraestructura.salida.mapeador.usuario;

import com.nexcode.parkingpro.dominio.modelo.Usuario;
import com.nexcode.parkingpro.infraestructura.salida.persistencia.usuario.UsuarioEntidad;
import com.nexcode.parkingpro.infraestructura.entrada.dto.respuesta.UsuarioRespuesta;
import com.nexcode.parkingpro.infraestructura.entrada.dto.solicitud.UsuarioSolicitud;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UsuarioMapeador {

    /**
     * Convierte el modelo de dominio (Usuario) a la entidad de persistencia (UsuarioEntidad).
     * @param modelo El objeto de dominio a mapear.
     * @return La entidad de persistencia mapeada.
     */
    UsuarioEntidad aEntidad(Usuario modelo);

    /**
     * Convierte la entidad de persistencia (UsuarioEntidad) al modelo de dominio (Usuario).
     * @param entidad La entidad de persistencia a mapear.
     * @return El objeto de dominio mapeado.
     */
    Usuario aDominio(UsuarioEntidad entidad);

    /**
     * Convierte el modelo de dominio (Usuario) a la respuesta de infraestructura (UsuarioRespuesta).
     * @param modelo La entidad de persistencia a mapear.
     * @return El objeto de dominio mapeado.
     */
    UsuarioRespuesta aRespuesta(Usuario modelo);

    /**
     * Convierte el modelo de solicitud (UsuarioSolicitud) al modelo de dominio (Usuario).
     * @param solicitud La entidad de persistencia a mapear.
     * @return El objeto de dominio mapeado.
     */
    Usuario aDominio(UsuarioSolicitud solicitud);
}