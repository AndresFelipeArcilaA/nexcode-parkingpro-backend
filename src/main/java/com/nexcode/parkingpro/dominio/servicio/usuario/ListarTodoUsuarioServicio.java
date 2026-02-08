package com.nexcode.parkingpro.dominio.servicio.usuario;

import com.nexcode.parkingpro.dominio.modelo.Usuario;
import com.nexcode.parkingpro.dominio.puertos.usuario.UsuarioPersistencia;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarTodoUsuarioServicio {

    private final UsuarioPersistencia persistencia;

    public List<Usuario> ejecutar() {
        return persistencia.listarTodo();
    }
}
