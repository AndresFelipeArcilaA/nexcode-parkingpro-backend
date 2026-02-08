package com.nexcode.parkingpro.dominio.puertos.usuario;

import com.nexcode.parkingpro.dominio.modelo.Usuario;

import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;

public interface UsuarioPersistencia {

    Usuario guardar(Usuario usuario);

    Usuario buscarPorId(Long id);

    List<Usuario> listarTodo();

    void eliminar(Long id);

    void actualizar(Usuario usuario);

    Usuario buscarPorCorreoYContrasena(String correo, String contrasena);


}
