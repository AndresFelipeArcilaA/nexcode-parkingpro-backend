package com.nexcode.parkingpro.aplicacion.casodeuso.usuario;

import com.nexcode.parkingpro.dominio.modelo.Usuario;
import com.nexcode.parkingpro.dominio.servicio.usuario.*;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.math.BigDecimal;


@Component
@RequiredArgsConstructor
public class UsuarioCasoDeUso {

    private final GuardarUsuarioServicio guardarServicio;
    private final EliminarUsuarioServicio eliminarServicio;
    private final BuscarPorIdUsuarioServicio buscarPorIdServicio;
    private final ListarTodoUsuarioServicio listarTodoServicio;
    private final ActualizarUsuarioServicio actualizarServicio;
    private final IniciarSesionServicio iniciarSesionServicio;

    public Usuario guardarUsuario(Usuario usuario) {
        return guardarServicio.ejecutar(usuario);
    }

    public void eliminar(Long id) {
        eliminarServicio.ejecutar(id);
    }

    public Usuario buscarPorId(Long id) {
        return buscarPorIdServicio.ejecutar(id);
    }

    public List<Usuario> listarTodos() {
        return listarTodoServicio.ejecutar();
    }

    public void actualizarUsuario(Usuario usuario) {
        actualizarServicio.ejecutar(usuario);
    }

    public Usuario iniciarSesion(String correo, String contrasena) {
        return iniciarSesionServicio.ejecutar(correo, contrasena);
    }
}